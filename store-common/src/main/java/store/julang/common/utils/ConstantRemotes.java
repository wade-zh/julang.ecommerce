package store.julang.common.utils;

import store.julang.common.config.RemoteNameManager;

import static store.julang.common.config.RemoteNameManager.RemoteNameEnum.USER;

/***
 * 远程服务URL工具类
 * @author HongWei
 * @date 2018年3月26日12:08:58
 */
public class ConstantRemotes {
    /**
     * 获取User服务URL
     * @return
     */
    public static String getUser(){
        return format(RemoteNameManager.get(USER));
    }

    /**
     * 格式化链接
     * @param name
     * @return
     */
    private static String format(String name){
        return String.format("//%s/", name);
    }
}
