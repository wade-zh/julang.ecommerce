package store.julang.common.io;

import org.apache.log4j.Logger;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

/***
 * Properties文件工具类
 * @author HongWei
 * @version v1.0
 * @date 2018年3月15日17:57:53
 */
public class PropertiesUtil {
    private static Properties properties;
    private static URL url;

    /**
     * 装载文件
     */
    public PropertiesUtil load(String fileName){
        try{
            properties = new Properties();
            if(fileName.indexOf(".properties") == -1) fileName += ".properties";
            InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
            properties.load(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 获取内容
     * @param key
     * @return
     */
    public String getValue(String key){
        return properties.get(key).toString();
    }
}

