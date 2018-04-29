package store.julang.common.network;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import store.julang.common.exception.TraceException;

/***
 * 远程调用客户端类
 * @author HongWei
 * @date 2018年3月26日09:42:24
 */
public class RestClient {

    // 支持直连/服务发现两种调用方式
    private RestTemplate lbRestTemplate;
    private RestTemplate directRestTemplate;
    private final String directFlag = "direct://";

    public RestClient() {
        lbRestTemplate = new RestTemplate();
        directRestTemplate = new RestTemplate();
    }

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
    public <T, R> ResponseEntity<R> post(String url, T body) {
        RestTemplate template = getRestTemplate(url);
        ParameterizedTypeReference parameterizedTypeReference = new ParameterizedTypeReference<T>() {};
        try {
            return template.exchange(url, HttpMethod.POST, new HttpEntity(body), parameterizedTypeReference);
        } catch (RestClientException e) {
            // TODO 上报异常数据
            return null;
        }
    }

    /**
     * GET请求--无验签
     *
     * @param url 接口地址
     * @param <T> 参数类型
     * @return 响应体
     * @author HongWei
     */
    public <T> ResponseEntity<T> get(String url) {
        RestTemplate template = getRestTemplate(url);
        ParameterizedTypeReference parameterizedTypeReference = new ParameterizedTypeReference<T>() {
        };
        try {
            return template.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, parameterizedTypeReference);
        } catch (RestClientException e) {
            // TODO 上报异常数据
            return null;
        }
    }

    /**
     * 判断url参数，获取RestTemplate对象
     *
     * @param url
     * @return
     */
    private RestTemplate getRestTemplate(String url) {
        if (url.contains(directFlag)) {
            return directRestTemplate;
        } else {
            return lbRestTemplate;
        }
    }
}


