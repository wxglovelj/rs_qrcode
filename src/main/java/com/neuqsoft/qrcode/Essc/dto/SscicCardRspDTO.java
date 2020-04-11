package com.neuqsoft.qrcode.Essc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SscicCardRspDTO", description = "实体社保卡接口响应DTO")
public class SscicCardRspDTO {

    @ApiModelProperty("响应状态码")
    private String code;

    @ApiModelProperty("响应信息")
    private String msg;

    @ApiModelProperty("响应时间")
    private String time;

    @ApiModelProperty("业务代码")
    private String busiCode;

    @ApiModelProperty("业务数据")
    private BusiDataCard busiData;

    @Data
    public static class BusiDataCard {

        @ApiModelProperty("实体社保卡卡号")
        private String ssciccard;

        private String sid;

        @ApiModelProperty("社会保障号码")
        private String idcard;

        @ApiModelProperty("姓名")
        private String name;
    }
}
