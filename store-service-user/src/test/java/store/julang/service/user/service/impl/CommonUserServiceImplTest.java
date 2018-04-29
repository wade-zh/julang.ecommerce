package store.julang.service.user.service.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import store.julang.service.user.mapper.IUserMapper;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class CommonUserServiceImplTest extends CommonUserServiceImpl {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CommonUserServiceImpl mockThat;

    public CommonUserServiceImplTest(IUserMapper userMapper) {
        super(userMapper);
    }


    @Before
    public void setUp() throws Exception {
        mockThat = mock(CommonUserServiceImpl.class);
    }

    /**
     * 测试添加新用户方法传递null参数--预期抛出空异常
     */
    @Test(expected = NullPointerException.class)
    public void testAddExpectThrowNullPointerException() throws Exception {
        when(mockThat.reg(null, null, null))
                .thenThrow(NullPointerException.class);
        mockThat.reg(null, null, null);
    }

    /**
     * 测试添加新用户内部逻辑传递错误邮箱--预期抛出Exception异常并且message一致
     * @throws Exception
     */
    @Test
    public void testAddExpectThrowException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("邮箱格式不正确");
        if(!Util.matchEmail("a@a.a")) throw new Exception("邮箱格式不正确");
    }
}