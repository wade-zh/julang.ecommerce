package store.julang.user.web.remote.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import store.julang.common.network.RestCaller;
import store.julang.common.network.UserRestCaller;
import store.julang.common.utils.ConstantRemotes;
import store.julang.entity.shared.users.MapDataPubEntity;
import store.julang.user.web.remote.IMapDatasRemote;

import java.util.List;

/***
 * 数据字典remote实现类
 * @author HongWei
 * @date 2018年3月26日11:52:35
 */
@Repository
public class MapDatasRemoteImpl implements IMapDatasRemote {

    /**
     * 拉取登录页面配置信息
     *
     * @return
     */
    @Override
    public List<MapDataPubEntity> fetchLoginConfig() {
        ResponseEntity<Object> entity = RestCaller.create(UserRestCaller.class)
                .get(ConstantRemotes.getUser() + "entrance/fetchLoginConfig");
        return (List<MapDataPubEntity>) entity.getBody();
    }
}
