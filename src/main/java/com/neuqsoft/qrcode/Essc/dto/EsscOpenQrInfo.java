package com.neuqsoft.qrcode.Essc.dto;

import com.neuqsoft.qrcode.contant.sign.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EsscOpenQrInfo extends BaseDTO {

    @ApiModelProperty("电子社保卡卡号")
    private String esscNo;

    @ApiModelProperty("签发等级")
    private String signLevel;

//    @JsonIgnore
//    @ApiModelProperty("签名")
//    private String checkNo;

    @ApiModelProperty("社会保障号码")
    private String idcard;

    @ApiModelProperty("姓名")
    private String name;

}
