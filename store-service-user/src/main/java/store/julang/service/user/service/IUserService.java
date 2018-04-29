package store.julang.service.user.service;

/***
 * 用户服务接口
 * @author HongWei
 * @date 2018年3月29日11:33:15
 */
public interface IUserService {

    /**
     * 注册账户
     * @param uname
     * @param pwd
     * @param email
     * @return
     */
    public boolean reg(String uname, String pwd, String email) throws Exception;

    /**
     * 登录账户
     * @param uname
     * @param pwd
     * @return
     */
    public boolean login(String uname, String pwd);
}
