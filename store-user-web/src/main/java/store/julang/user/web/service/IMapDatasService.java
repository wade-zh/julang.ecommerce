package store.julang.user.web.service;

import store.julang.entity.shared.users.MapDataPubEntity;

import java.util.List;

/***
 * 数据字典服务接口
 * @author HongWei
 * @date 2018年3月24日11:06:25
 */
public interface IMapDatasService {

    /**
     * 拉取登录页面配置信息
     * @author HongWei
     * @return 单个或多个配置节点信息
     */
    List<MapDataPubEntity> FetchLoginPageConfigs();
}
