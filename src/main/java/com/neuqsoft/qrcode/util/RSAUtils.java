package com.neuqsoft.qrcode.util;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RSAUtils {
    //解密用，后端私钥
    static String iv="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALi/AbW+YalkDz+9hcFaH5vk531shMMl7NzFpk6S+kuU9QjjRiH+SRwEx8P1Bq9GLHiEfm3DNQyFHcxWlVhlHNgO/JX9qsxb85Z48BomLB150+pOhb7Z+6lhTYO1UK+mYJo3EWUfvorTm9Hnx49A41o4E/GKVvGcA+awTqUqMJ6RAgMBAAECgYA+uvSsrolgyA35ebPqFFz5RT9pMijeTolf6Wjv8y4z7c9KBknxDvPqJKFkI1Xyu+Qrw+leAdOIfcbBdIDfc+3Xxm4ehijpO0OhRncm/fiIf7u9DoaOpQTwKDauDJ9pan4xKBLA6te6iSI+8yXNrPda2ouN89XXbgAUy5d95/5vsQJBAPWiLSytiNEJpg7p/W8SQN/72Ca/pJsOh0gvr9y614n1qP25CU4pY8mrzn3WRWFup4rwnre7kaWs0pWy2eskRB0CQQDAiwDODP802n6Uj51xv5terQZt/8U8UdZ3+Cvzw55Qz9BgeLVNTSrNXwPelcmJQWo2nk7KscsRI4UIGGCTMlIFAkAOEPh3S4S/O8c3qWyq9Keka/6n0WeyvXU/zANNJ6H6M4g252bCBBrDzMPpbuDQQI71pOvh56riivAQRIq4LX59AkA2NezgFuCz7OC+y0C1ChGgsm6hAeZyeUg9Nu6JD4a/kgNFZjcFsLhgYmQgg2Pe9UAGaMQeZbia9rk58kMerohRAkEAv3869lKIioLanopOkajAok88OxqzDo9gJ3lRhni+5jKO6U10zrCxzlWwQU/U60yIy4bCTk4jaFeHfZ0hDgfPww==";
//    static String iv1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQGk06U1yh9OljxQUAMkt+1egx\n" +
//            "W0f9GUpfuP3ULbqadwznlC6RZCIYg0r9HD95Q2mu3yvFgJHoRkAAW1ROSOz1O4Dx\n" +
//            "uk1Q3CbPkUyFxlJ3Il5TuOETWejzjQ9cbP+e8bwosgRFvvx1ENxCsjQ7CDRUOxaM\n" +
//            "DEUeg302NVncDD7f3QIDAQAB";//加密用，前端公钥
    static String iv1 ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4vwG1vmGpZA8/vYXBWh+b5Od9bITDJezcxaZOkvpLlPUI40Yh/kkcBMfD9QavRix4hH5twzUMhR3MVpVYZRzYDvyV/arMW/OWePAaJiwdedPqToW+2fupYU2DtVCvpmCaNxFlH76K05vR58ePQONaOBPxilbxnAPmsE6lKjCekQIDAQAB";
    private final static Logger logger = LoggerFactory.getLogger(RSAUtils.class);
    private static RSAUtil rsaUtil=new RSAUtil(iv,iv1);

    /**
     * 加密
     *
     * @param data 需要加密的内容
     * @return
     */
    public static String encrypt(Object data) {
        String content="";
        try{
            content=encrypt(new Gson().toJson(data));
        }catch (Exception e){
            logger.error("aes error:", e);
        }
        return content;
    }
    public static String encrypt(String data) {
        String content="";
        try{
            content=rsaUtil.encrypt(data);
        }catch (Exception e){
            logger.error("aes error:", e);
        }
        return content;
    }
    /**
     * 解密
     *
     * @param data 待解密内容
     * @return
     */
    public static String decrypt(String data) {
        String content="";
        try{
            content=rsaUtil.decrypt(data);
        }catch (Exception e){
            logger.error("aes error:", e);
        }
        return content;
    }

    public static <T> T decrypt(String data, Class<T> responseType) {
        return new Gson().fromJson(decrypt(data), responseType);
    }


    public static String encrypt(Object data, String key) {
        String content="";
        try{
            content=encrypt(new Gson().toJson(data),key);
        }catch (Exception e){
            logger.error("aes error:", e);
        }
        return content;
    }
    public static String encrypt(String data, String key) {
        String content="";
        try{
            content=rsaUtil.encrypt(data,key);
        }catch (Exception e){
            logger.error("aes error:", e);
        }
        return content;
    }

    public static String decrypt(String data, String key) {
        String content="";
        try{
            content=rsaUtil.decrypt(data,key);
        }catch (Exception e){
            logger.error("aes error:", e);
        }
        return content;
    }

}
