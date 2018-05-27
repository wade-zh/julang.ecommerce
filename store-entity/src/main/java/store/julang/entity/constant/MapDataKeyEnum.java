package store.julang.entity.constant;

/***
 * 数据字典键名枚举类
 * @author HongWei
 * @date 2018年3月24日16:34:16
 */
public enum MapDataKeyEnum {

    PAGE_USER_TITLE("page_user_login_title"),
    PAGE_USER_KEYWORDS("page_user_login_keywords"),
    PAGE_USER_DESCRIPTION("page_user_login_description"),
    PAGE_USER_BRAND("page_user_brand"),
    PAGE_USER_BRAND_DESC("page_user_brand_desc");

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    MapDataKeyEnum(String key) {
        this.key = key;
    }
}
