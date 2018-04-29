package store.julang.user.web.config;

import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import store.julang.common.config.DomainsManager;
import store.julang.user.web.service.IMapDatasService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/***
 * 模板引擎上下文配置类
 * @author HongWei
 * @date 2018年3月23日15:21:34
 */
@Configuration
public class ThymeleafContextConfiguration {

    @Resource
    private IMapDatasService mapDatasService;

    /**
     * 配置全局变量
     * @author HongWei
     * @param viewResolver
     */
    @Resource
    private void configureThymeleafVars(ThymeleafViewResolver viewResolver) {
        if(viewResolver == null) return;

        Map<String, Object> vars = new HashMap<>();

        // 提取前端模板引擎静态配置信息
        extractTemplateStaticVars(vars);

        // 提取域名列表中的信息
        extractDomainManager(vars);

        // 提取多页面动态配置信息
        extractMultiPageSettings(vars);

        viewResolver.setStaticVariables(vars);
    }

    /**
     * 提取多页面动态配置信息
     * @param vars
     */
    private void extractMultiPageSettings(Map<String, Object> vars) {
        mapDatasService.FetchLoginPageConfigs().stream().forEach(data -> { vars.put(data.getMKey(), data.getMValue()); });
    }

    /**
     * 提取域名列表中的信息
     * @param vars
     */
    private void extractDomainManager(Map<String, Object> vars) {
        vars.put("domain_gateway_user", DomainsManager.get(DomainsManager.DomainEnum.DOMAIN_GATEWAY_USER));
        vars.put("domain_resource", DomainsManager.get(DomainsManager.DomainEnum.DOMAIN_RESOURCE));
    }

    /**
     * 提取前端模板引擎静态配置信息
     * @param vars
     */
    private void extractTemplateStaticVars(Map<String, Object> vars) {
        vars.put("link","shared/common/link");
        vars.put("script","shared/common/script");
    }
}
