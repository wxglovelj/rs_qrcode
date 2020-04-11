package com.neuqsoft.qrcode.Essc.api;

import com.neuqsoft.qrcode.Essc.dto.EsscQrInfoReq;
import com.neuqsoft.qrcode.Essc.service.EsscService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("电子社保卡调用入口")
@RequestMapping("/api/essc")
public class EsscApi {

    @Autowired
    private EsscService esscService;


    @ApiOperation("二维码解析")
    @PostMapping("/qrcode")
    public String  getQrInfo(@RequestBody EsscQrInfoReq esscQrInfoReq) {
        System.out.println("入参EsscQrInfoReq:"+esscQrInfoReq);
        return esscService.getQrInfo(esscQrInfoReq.getQrCode(), esscQrInfoReq.getBusiType());
    }


}
