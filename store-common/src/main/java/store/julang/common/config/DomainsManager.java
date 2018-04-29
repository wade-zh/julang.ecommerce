package store.julang.common.config;

import store.julang.common.io.PropertiesUtilFactory;

/***
 * 全局常量数据
 * @author HongWei
 * @version 1.0
 * @date 2018年3月15日17:39:00
 */
public class DomainsManager {

    // 配置文件路径
    private static final String configPath = "domain-manager";

    /**
     * 根据节点名获取主机域名
     *
     * @param domainEnum 内部域名枚举类
     * @return 域名，末尾带/
     */
    public static String get(DomainEnum domainEnum) {
        return PropertiesUtilFactory.create().load(configPath).getValue(domainEnum.getNode());
    }

    /***
     * 内部域名枚举类
     * @author HongWei
     * @date 2018年3月23日15:11:26
     */
    public enum DomainEnum {
        // 静态资源站点
        DOMAIN_RESOURCE("domain.static"),
        DOMAIN_GATEWAY_USER("domain.gateway.user");

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }

        private String node;

        private DomainEnum(String nodeName) {
            this.node = nodeName;
        }

    }
}

