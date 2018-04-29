package store.julang.common.network;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.Callable;

public class RestCallerTests {

    /**
     * 测试创建调用者服务--返回结果不为null对象通过测试
     */
    @Test
    public void testCreateReturnNotNullObject() {
        UserRestCaller restCaller = RestCaller.create(UserRestCaller.class);
        assert restCaller != null;
    }
}

