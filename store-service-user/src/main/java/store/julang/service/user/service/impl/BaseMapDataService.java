package store.julang.service.user.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import store.julang.common.utils.PropertyUtil;
import store.julang.entity.shared.users.MapDataPubEntity;
import store.julang.service.user.entity.MapDataEntity;
import store.julang.service.user.mapper.IMapDataMapper;

import java.util.List;
import java.util.Optional;

/***
 * 数据字典基础服务类
 */
public abstract class BaseMapDataService {
    @Autowired
    protected IMapDataMapper mapDataMapper;

    /**
     * 获取数据字典中的内容--command设计模式
     * @return
     */
    protected abstract List<MapDataPubEntity> execute();

    /***
     * 内部工具类
     * @author HongWei
     */
    protected static class Util{

        /**
         * 类型转换器
         * @param list
         * @return
         */
        public static List<MapDataPubEntity> convert(List<MapDataEntity> list){
            List<MapDataPubEntity> mapDataPubEntities = Lists.newArrayList();
            Optional.ofNullable(list).orElse(Lists.newArrayList()).forEach(item -> {
                MapDataPubEntity mapDataPubEntity = new MapDataPubEntity();
                PropertyUtil.clone(item, mapDataPubEntity);
                mapDataPubEntities.add(mapDataPubEntity);
            });
            return mapDataPubEntities;
        }
    }
}
