package store.julang.service.user.mapper;


import org.apache.ibatis.annotations.Mapper;
import store.julang.service.user.entity.MapDataEntity;

import java.util.List;

/***
 * 数据字典表仓储服务接口
 * @author HongWei
 * @date 2018年3月27日10:09:49
 */
@Mapper
public interface IMapDataMapper {

    /**
     * 查询条件范围内的数据--根据mKey字段批量查询
     * @param keys
     * @return
     */
    List<MapDataEntity> selectAny(List<String> keys);

}
