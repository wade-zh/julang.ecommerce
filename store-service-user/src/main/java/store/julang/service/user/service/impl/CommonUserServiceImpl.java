package store.julang.service.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import store.julang.common.utils.SecrecyUtil;
import store.julang.service.user.entity.UserEntity;
import store.julang.service.user.mapper.IUserMapper;
import store.julang.service.user.service.IUserService;

import java.util.Objects;

/***
 * 普通用户服务实现类
 * @author HongWei
 * @date 2018年3月29日16:14:22
 */
@Service("commonUserService")
public class CommonUserServiceImpl implements IUserService {
    private final IUserMapper userMapper;

    @Autowired
    public CommonUserServiceImpl(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 添加新账户
     *
     * @param uname
     * @param pwd
     * @param email
     * @return
     */
    @Override
    public boolean reg(String uname, String pwd, String email) throws Exception {
        Objects.requireNonNull(uname);
        Objects.requireNonNull(pwd);
        Objects.requireNonNull(email);
        if(!Util.matchEmail(email)) throw new Exception("邮箱格式不正确");
        /*
            添加新账户流程
            1.校验数据是否符合格式
            2.对用户密码进行加密 salt: md5(md5(uname + pwd + email))
            3.注册成功后向邮件队列投递消息
         */
        Integer userId = userMapper.insert(uname, pwd, email);
        return userId != null && userId > 0;
    }

    /**
     * 登录账户
     *
     * @param uname
     * @param pwd
     * @return
     */
    @Override
    public boolean login(String uname, String pwd) {
        /*
            登录流程
            1、校验账户信息是否正确
            2、存入redis中，为日后SSO做准备
         */
        UserEntity user = userMapper.select(uname, SecrecyUtil.encrypt(pwd));
        // TODO 存入Redis缓存中
        return user != null;
    }


    /**
     * 内部工具类
     */
    public static class Util{

        /**
         * 匹配邮箱格式
         * @param email
         * @return
         */
        public static boolean matchEmail(String email) {
            return email.contains("@") && email.length() >= 6;
        }
    }
}
