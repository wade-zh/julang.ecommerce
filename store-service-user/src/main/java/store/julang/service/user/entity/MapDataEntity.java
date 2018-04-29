package store.julang.service.user.entity;

/***
 * 数据字典表映射实体
 */
public class MapDataEntity {
    /**
     * 字典ID
     */
    private Integer mapId;

    /**
     * 键
     */
    private String MKey;

    /**
     * 值
     */
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

    public MapDataEntity() {
    }

    public MapDataEntity(Integer mapId, String MKey, String MValue) {

        this.mapId = mapId;
        this.MKey = MKey;
        this.MValue = MValue;
    }
}
