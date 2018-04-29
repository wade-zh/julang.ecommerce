package store.julang.product.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import store.julang.product.remote.IMapClient;

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
    private IMapClient mapClient;

    /**
     * 配置全局变量
     *
     * @param viewResolver
     * @author HongWei
     */
    @Resource
    private void configureThymeleafVars(ThymeleafViewResolver viewResolver) {
        if (viewResolver == null) return;

        Map<String, Object> vars = new HashMap<>();

        // 远程加载通用配置信息
        vars.putAll(mapClient.getThContextVars());

        viewResolver.setStaticVariables(vars);
    }

}
