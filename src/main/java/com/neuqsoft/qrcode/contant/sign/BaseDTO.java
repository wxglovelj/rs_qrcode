package com.neuqsoft.qrcode.contant.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author baidonghuiPC baidh@neuqsoft.com
 * @create 2017-10-09 16:57
 */
@Data
@ToString(exclude = {"nonceStr", "sign"})
public abstract class BaseDTO implements IBaseDTO {
    //客户端标识
    @NotBlank
    @ApiModelProperty(value = "调用方标识（开发商）", required = true)
    private String clientId;

    /**
     * 签名
     * 描述：签名，详见签名生成算法
     */
    @NotBlank
    @ApiModelProperty(value = "数据签名", required = true, position = 26)
    private String sign;

    /**
     * 随机字符串
     * 描述：详见随机字符串算法。
     */
    @NotBlank
    @ApiModelProperty(value = "随机字符串", required = true, position = 27)
    private String nonceStr;

}
