package store.julang.common.network;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

/***
 * 服务调用者基接口
 * @author HongWei
 * @date 2018年3月26日09:45:14
 */
public interface BaseRestCaller {

    /**
     * POST请求--无验签
     *
     * @param url  接口地址
     * @param body 实体数据
     * @param <T>  参数类型
     * @param <R>  返回对象类型
     * @return 响应体
     * @author HongWei
     */
    default <T, R> ResponseEntity<T> post(String url, R body) {
        return RestClientFactory.create().post(protocalSupport(url), body);
    }

    /**
     * GET请求--无验签
     *
     * @param url 接口地址
     * @param <T> 参数类型
     * @return 响应体
     * @author HongWei
     */
    default <T> ResponseEntity<T> get(String url) {
        return RestClientFactory.create().get(protocalSupport(url));
    }

    /**
     * 协议支持
     *
     * @param url
     * @return
     */
    default String protocalSupport(String url) {
        if (!url.contains("https") && !url.contains("http")) url = "http:" + url;
        return url;
    }


    /**
     * GET请求--无验签
     *
     * @param url 接口地址
     * @param <T> 参数类型
     * @return 响应体
     * @author HongWei
     */
    default <T> ResponseEntity<T> asyncGet(String url) {
        return RestClientFactory.create().get(protocalSupport(url));
    }

}
