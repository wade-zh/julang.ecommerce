package store.julang.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/***
 * SQL语句工具类
 * @author HongWei
 * @date 2018年3月28日16:21:48
 */
public class SQLUtil {

    /**
     * 将普通属性转换成数据库格式的VARCHAR类型
     * @param list
     * @return
     */
    public static <T> List<String> toVarchar(List<T> list){
        Objects.requireNonNull(list);
        List<String> strList = new ArrayList<>();
        list.forEach(item -> strList.add("'" + item + "'"));
        return strList;
    }
}
