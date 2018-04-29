package store.julang.service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import store.julang.common.config.DomainsManager;
import store.julang.entity.shared.users.MapDataPubEntity;
import store.julang.service.user.service.IMapDataService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 入口服务Rest控制器
 * @author HongWei
 * @date 2018年3月26日09:19:46
 */
@RestController
@RequestMapping("/maps")
public class MapsRestController {

    @Autowired
    @Qualifier("loginMapDataService")
    private IMapDataService loginMapDataService;

    /**
     * 获取上下文静态变量池数据
     *
     * @return
     */
    @RequestMapping(value = "/variables", method = RequestMethod.GET)
    public Map<String, Object> getThContextVars() {
        Map<String, Object> vars = new HashMap<>();

        // 提取前端模板引擎静态配置信息
        vars.put("link", "shared/common/link");
        vars.put("script", "shared/common/script");

        // 提取域名列表中的信息
        vars.put("domain_gateway_user", DomainsManager.get(DomainsManager.DomainEnum.DOMAIN_GATEWAY_USER));
        vars.put("domain_resource", DomainsManager.get(DomainsManager.DomainEnum.DOMAIN_RESOURCE));

        // 提取多页面动态配置信息
        loginMapDataService.get().stream().forEach(data -> {
            vars.put(data.getMKey(), data.getMValue());
        });

        return vars;
    }
}
