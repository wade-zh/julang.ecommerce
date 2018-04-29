package store.julang.user.web.remote;

import store.julang.entity.shared.users.MapDataPubEntity;

import java.util.List;


/***
 * 数据字典remote接口
 * @author HongWei
 * @date 2018年3月26日11:52:35
 */
public interface IMapDatasRemote {

    /**
     * 拉取登录页面配置信息
     * @return
     */
    List<MapDataPubEntity> fetchLoginConfig();
}
