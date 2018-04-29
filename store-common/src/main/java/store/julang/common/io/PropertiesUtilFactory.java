package store.julang.common.io;

public class PropertiesUtilFactory{
    private static PropertiesUtil propertiesUtil = null;

    public static PropertiesUtil create(){
        if(propertiesUtil == null) propertiesUtil = new PropertiesUtil();
        return propertiesUtil;
    }
}
