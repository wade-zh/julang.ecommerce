package store.julang.user.web.service.impl;

import org.springframework.stereotype.Service;
import store.julang.entity.enums.MapDataKeyEnum;
import store.julang.entity.shared.users.MapDataPubEntity;
import store.julang.user.web.service.IMapDatasService;

import java.util.List;

import static java.util.Arrays.asList;

/***
 * 数据字典服务实现类
 * @author HongWei
 * @date 2018年3月24日11:16:19
 */
@Service
public class MapDatasServiceImpl implements IMapDatasService {

        /**
     * 拉取登录页面配置信息
     *
     * @return 单个或多个配置节点信息
     * @author HongWei
     */
    @Override
    public List<MapDataPubEntity> FetchLoginPageConfigs() {
        return asList(
                new MapDataPubEntity(1, MapDataKeyEnum.PAGE_USER_TITLE.getKey(), "巨浪"),
                new MapDataPubEntity(1, MapDataKeyEnum.PAGE_USER_KEYWORDS.getKey(), "#"),
                new MapDataPubEntity(1, MapDataKeyEnum.PAGE_USER_DESCRIPTION.getKey(), "#"),
                new MapDataPubEntity(1, MapDataKeyEnum.PAGE_USER_BRAND.getKey(), "巨浪"),
                new MapDataPubEntity(1, MapDataKeyEnum.PAGE_USER_BRAND_DESC.getKey(), "初创型电商平台")
        );
    }
}
