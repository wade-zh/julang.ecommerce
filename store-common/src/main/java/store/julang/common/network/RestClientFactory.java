package store.julang.common.network;

/***
 * 远程调用客户端工厂类
 * @author HongWei
 * @date 2018年3月26日09:42:06
 */
public class RestClientFactory {
    private static RestClient restClient;

    /**
     * 获取restClient对象，存在则返回，否则创建新对象
     * @return
     */
    public static RestClient create(){
        if(restClient == null) restClient = new RestClient();
        return restClient;
    }
}
