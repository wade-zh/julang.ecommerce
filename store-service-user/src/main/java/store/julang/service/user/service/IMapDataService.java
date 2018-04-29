package store.julang.service.user.service;

import store.julang.entity.shared.users.MapDataPubEntity;

import java.util.List;

/***
 * 数据字典服务接口
 * @author HongWei
 * @date 2018年3月26日09:13:30
 */
public interface IMapDataService {
    /***
     * 获取数据字典中的内容
     * @return
     */
    public List<MapDataPubEntity> get();
}
