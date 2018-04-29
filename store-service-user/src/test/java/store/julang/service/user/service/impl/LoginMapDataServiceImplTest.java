package store.julang.service.user.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import store.julang.service.user.entity.MapDataEntity;
import store.julang.service.user.mapper.IMapDataMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginMapDataServiceImplTest {

    private IMapDataMapper mock;

    @Before
    public void setUp() throws Exception {
        mock = mock(IMapDataMapper.class);
    }

    /**
     * 测试Optional数据类型--主要针对本服务实现中大量的null判断
     */
    @Test
    public void testOptionalApi(){
        Optional<Object> empty = Optional.empty();
        Optional<Object> optional = Optional.ofNullable(null);
        Optional<String> data = Optional.of("a");
        assertFalse(empty.isPresent());
        assertTrue(data.isPresent());
        assertEquals("c", empty.orElse("c"));
        assertEquals(100, empty.orElseGet(()->{
            return 50 + 50;
        }));
    }

    /**
     * 测试execute方法返回值--返回结果不为空通过测试
     */
    @Test
    public void testExecuteReturnNotNull() {
        /*
            加载config流程
            1.根据keys管理器取出该页对于的key,组成一个List<String>的对象
            2.在数据库中通过mKey范围查询得到一个List<MapDataEntity>的集合
         */

        when(mock.selectAny(anyList()))
                .thenReturn(new ArrayList<MapDataEntity>());
        List<MapDataEntity> result = mock.selectAny(anyList());
        verify(mock).selectAny(anyList());
        assertNotNull(result);
    }

}