package store.julang.service.user.service.impl;

import org.springframework.stereotype.Service;
import store.julang.entity.constant.MapDataKeyEnum;
import store.julang.entity.shared.users.MapDataPubEntity;
import store.julang.service.user.service.IMapDataService;

import java.util.List;

import static java.util.Arrays.asList;

/***
 * 数据字典服务实现类
 * @author HongWei
 * @date 2018年3月26日09:15:53
 */
@Service("loginMapDataService")
public class LoginMapDataServiceImpl extends BaseMapDataService implements IMapDataService {

    /**
     * 获取数据字典中的内容--command设计模式
     *
     * @return
     */
    @Override
    protected List<MapDataPubEntity> execute() {
        return Util.convert(mapDataMapper.selectAny(asList(
                MapDataKeyEnum.PAGE_USER_TITLE.getKey(),
                MapDataKeyEnum.PAGE_USER_KEYWORDS.getKey(),
                MapDataKeyEnum.PAGE_USER_DESCRIPTION.getKey(),
                MapDataKeyEnum.PAGE_USER_BRAND.getKey(),
                MapDataKeyEnum.PAGE_USER_BRAND_DESC.getKey()
        )));
    }

    /***
     * 获取数据字典中的内容
     * @return
     */
    @Override
    public List<MapDataPubEntity> get() {
        return execute();
    }
}
