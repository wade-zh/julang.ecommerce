package store.julang.product.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import store.julang.common.enums.Constants;

import java.util.Map;

@FeignClient(value = "STORE-API-GATEWAY" )
public interface IMapClient {
    /**
     * 获取模板引擎上下文变量池
     *
     * @return
     */
    @RequestMapping(value = "/user-api/maps/variables", method = RequestMethod.GET)
    public Map<String, Object> getThContextVars();
}
