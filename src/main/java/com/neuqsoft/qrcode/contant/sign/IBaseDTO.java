package com.neuqsoft.qrcode.contant.sign;

public interface IBaseDTO {

    String getClientId();

    void setClientId(String clientId);

    String getSign();

    void setSign(String sign);

    String getNonceStr();

    void setNonceStr(String nonceStr);
}
