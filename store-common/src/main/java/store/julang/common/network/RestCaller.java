package store.julang.common.network;

import java.util.List;

import static java.util.Arrays.asList;

/***
 * 调用者抽象工厂类
 * @author HongWei
 * @date 2018年3月26日09:58:45
 */
public class RestCaller {

    private static List<BaseRestCaller> restCallers;

    /**
     * 创建指定类型的调用者
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> clazz){
        init();
        return (T) restCallers.stream().filter(obj -> obj.getClass().getName().equalsIgnoreCase(clazz.getName())).findFirst().get();
    }

    private static void init() {
        if(restCallers == null)
            restCallers = asList(
                    new UserRestCaller()
            );
    }

}
