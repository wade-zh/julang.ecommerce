package store.julang.entity.shared.users;

/***
 * 数据字典表共用实体
 * @author HongWei
 * @date  2018年3月24日11:09:40
 */
public class MapDataPubEntity {
    private Integer mapId;
    private String MKey;
    private String MValue;

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public String getMKey() {
        return MKey;
    }

    public void setMKey(String MKey) {
        this.MKey = MKey;
    }

    public String getMValue() {
        return MValue;
    }

    public void setMValue(String MValue) {
        this.MValue = MValue;
    }

    public MapDataPubEntity() {
    }

    public MapDataPubEntity(Integer mapId, String MKey, String MValue) {

        this.mapId = mapId;
        this.MKey = MKey;
        this.MValue = MValue;
    }}
