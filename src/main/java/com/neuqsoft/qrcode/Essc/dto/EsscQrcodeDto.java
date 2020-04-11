package com.neuqsoft.qrcode.Essc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EsscQrcodeDto {
    @ApiModelProperty("社会保障号码")
    private String idcard;

    @ApiModelProperty("姓名")
    private String name;
}
