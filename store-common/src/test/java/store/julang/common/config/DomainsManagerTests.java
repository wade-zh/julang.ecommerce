package store.julang.common.config;

import org.junit.Test;
import store.julang.common.io.PropertiesUtil;

/***
 * 全局常量数据定义测试类
 * @author HongWei
 * @version v1.0
 * @date
 */
public class DomainsManagerTests {

    /**
     * 测试获取静态资源URL--返回结果不为空通过测试
     */
    @Test
    public void testGetResourceDomainNotEmpty(){
        String url = DomainsManager.get(DomainsManager.DomainEnum.DOMAIN_RESOURCE);
        assert url != null;
    }

    /**
     * 测试获取静态资源文件路径--返回路径不为空通过测试
     */
    @Test
    public void testGetResourceFilePathReturnNotEmpty(){
        String path = PropertiesUtil.class.getClassLoader().getResource("domain-manager.properties").getPath();
        System.out.println(path);
        assert path != null;
    }

}
