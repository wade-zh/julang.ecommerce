package store.julang.common.config;

import store.julang.common.io.PropertiesUtilFactory;

public class RemoteNameManager {

    // 配置文件路径
    private static final String configPath = "remote-name-manager";

    /**
     * 获取服务名
     * @param remoteNameEnum
     * @return
     */
    public static String get(RemoteNameEnum remoteNameEnum) {
        return PropertiesUtilFactory.create().load(configPath).getValue(remoteNameEnum.getName());
    }

    public enum RemoteNameEnum {
        EUREKA_SERVER("eureka-server"),
        USER("user");

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private RemoteNameEnum(String name) {
            this.name = name;
        }
    }
}
