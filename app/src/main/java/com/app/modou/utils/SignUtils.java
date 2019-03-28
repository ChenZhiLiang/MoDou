package com.app.modou.utils;

import android.util.Base64;
import android.util.Log;
import com.app.modou.ui.AppContext;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: SignUtils
 * @Description: 签名方法类
 * @CreateDate: 2019/3/25 16:09
 * @Version: 1.0
 */
public class SignUtils {

    /**
     * 获取私钥的key
     * @param  pwd 私钥密码
     */
    public static PrivateKey parsePfx(String path,String pwd) {
        PrivateKey prikey;
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            InputStream fis = null;
            try {
                fis = AppContext.getContext().getClass().getClassLoader().getResourceAsStream(path);
            } catch (Exception e) {
                Log.i("prikey", "new FileInputStream fail");
            }
            char[] nPassword = pwd.toCharArray();
            ks.load(fis, nPassword);
            fis.close();
            Enumeration<String> aliases = ks.aliases();
            String keyAlias ;
            while (true) {
                try {
                    keyAlias = aliases.nextElement();
                    prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
                    if (null != prikey) {
                        break;
                    } else {
                        Log.i("prikey", "prikey is null");
                    }
                } catch (NoSuchElementException e) {
                    Log.i("prikey", "NoSuchElementException");
                    return null;
                }
            }
            System.out.println("private key = " + prikey);
            return prikey;
        }
        catch (Exception e)  {
            Log.i("prikey", "parsePfx will return null");
            return null;
        }
    }
    /**
     * @return 签名
     * @param contenty 待签名数据
     */
    public static String sign(String contenty) {
        try {
            PrivateKey privateKey  = parsePfx("assets/100009000392.pfx","720083");
            //SHA1withRSA算法进行签名
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initSign(privateKey);
            byte[] data = contenty.getBytes("UTF-8");
            //更新用于签名的数据
            sign.update(data);
            byte[] signature = sign.sign();
            String result = new String(Base64.encode(signature, Base64.DEFAULT),"utf-8");
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
