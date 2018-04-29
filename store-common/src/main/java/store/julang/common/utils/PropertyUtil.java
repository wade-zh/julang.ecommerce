package store.julang.common.utils;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/***
 * 属性克隆工具类
 * @author HongWei
 * @date 2018年3月27日15:41:59
 */
public class PropertyUtil {

    /**
     * 属性伪深克隆--反射方式(性能一般)
     * @exception IllegalAccessException 赋值时可能会因为不明原因导致失败
     * @param clazz
     * @param nClazz
     * @param <T>
     * @param <R>
     */
    public static <T, R> void clone(T clazz, R nClazz) {
        /*
            利用反射原理将A类属性值赋值给B类对象
            1.获取两个类型的Class对象
            2.遍历A类所有字段，与B类字段比较，对相同名称且相同类型的字段筛选
            3.将A类字段内容赋值予B类字段，使B类型字段拥有新值
            4.如果有报错，请显式抛出异常给上游处理，方便开发人员追溯问题
         */
        Class<?> aClass = clazz.getClass();
        Class<?> bClass = nClazz.getClass();

        Field[] aClassFields = aClass.getDeclaredFields();
        Field[] bClassFields = bClass.getDeclaredFields();
        Arrays.stream(bClassFields)
                .filter(field -> match(aClassFields, field) != null)
                .forEach(item -> {
                    Field field = match(aClassFields, item);
                    field.setAccessible(true);
                    item.setAccessible(true);
                    try {
                        item.set(nClazz, field.get(clazz));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * 通过name与type对比对象是否符合克隆条件
     *
     * @param fields
     * @param item
     * @return
     */
    private static Field match(Field[] fields, Field item) {
        return Arrays.stream(fields).filter(field -> {
            item.setAccessible(true);
            field.setAccessible(true);
            return field.getName().equalsIgnoreCase(item.getName().trim()) && field.getType().equals(item.getType());
        }).findFirst().get();
    }

}
