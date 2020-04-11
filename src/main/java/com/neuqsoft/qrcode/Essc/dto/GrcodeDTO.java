package com.neuqsoft.qrcode.Essc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GrcodeDTO", description = "二维码解析DTO")
public class GrcodeDTO {

    @ApiModelProperty("响应信息")
    private String msg;

    @ApiModelProperty("响应状态码,成功：000000")
    private String msgCode;

    @ApiModelProperty("响应结果集")
    private Result result;

    @Data
    public static class Result {

        @ApiModelProperty("电子社保卡卡号")
        private String esscNo;

        @ApiModelProperty("签发等级")
        private String signLevel;

        @ApiModelProperty("签名")
        private String checkNo;

    }
}
