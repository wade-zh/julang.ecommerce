package store.julang.entity.message;

/***
 * 标准消息模型
 * @author HongWei
 * @date 2018年3月30日10:03:42
 */
public class StandardMessage {
    private Integer code;
    private Object message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = String.valueOf(message);
    }

    public StandardMessage(Object message) {
        this.message = String.valueOf(message);
    }

    public StandardMessage(Integer code, Object message) {
        this.code = code;
        this.message = String.valueOf(message);
    }

    public enum Codes{
        SUCCESS,
        FAILD,
        EXCEPTION,
        NONE
    }
}
