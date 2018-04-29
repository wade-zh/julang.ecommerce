package store.julang.common.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/***
 * 保密工具
 * @author HongWei
 * @date 2018年3月29日16:50:07
 */
public class SecrecyUtil {

    /**
     * 自定义salt加密
     * @param arr
     * @return
     */
    public static String encrypt(String... arr){
        String oneEncrypt = Hashing.md5().newHasher().putString(String.join(",", arr), Charsets.UTF_8).hash().toString();
        return Hashing.md5().newHasher().putString(oneEncrypt, Charsets.UTF_8).hash().toString();
    }
}
