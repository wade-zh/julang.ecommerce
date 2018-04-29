package store.julang.common.io;

import org.junit.Test;

public class PropertiesUtilTests {

    /**
     * 测试获取配置内容方法--返回结果不为空通过测试
     */
    @Test
    public void testGetValueNotEmpty() {
        String value = new PropertiesUtil().load("store/julang/common/config/base-conf").getValue("website.resource.url");
        assert value != null;
    }

}
