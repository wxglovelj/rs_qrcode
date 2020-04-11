package com.neuqsoft.qrcode.Essc.dto;

import com.neuqsoft.qrcode.contant.sign.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EsscQrInfoReq
 *
 * @author lizhongcheng
 * @date 2019/8/23 13:47
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "EsscQrInfoReq", description = "解析二维码入参信息")
public class EsscQrInfoReq extends BaseDTO {

    @ApiModelProperty(value = "部平台电子社保卡二维码", required = true)
    private String qrCode;

    @ApiModelProperty(value = "业务类型",required = true)
    private String busiType;
}
