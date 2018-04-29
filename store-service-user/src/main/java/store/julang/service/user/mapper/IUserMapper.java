package store.julang.service.user.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import store.julang.service.user.entity.UserEntity;

/***
 * 用户表仓储服务接口
 */
@Mapper
public interface IUserMapper {

    /**
     * 注册账号
     * @param uname
     * @param pwd
     * @param email
     * @return 主键
     */
    Integer insert(@Param("userName") String uname, @Param("password") String pwd, @Param("email") String email);

    /**
     * 查询信息
     * @param uname
     * @param pwd
     * @return
     */
    UserEntity select(@Param("userName") String uname, @Param("password") String pwd);
}
