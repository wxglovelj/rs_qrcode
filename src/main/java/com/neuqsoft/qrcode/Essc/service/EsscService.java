package com.neuqsoft.qrcode.Essc.service;

import com.neuqsoft.commons.spring.exception.GlobalException;
import com.neuqsoft.qrcode.Essc.dto.EsscOpenQrInfo;
import com.neuqsoft.qrcode.Essc.dto.EsscQrcodeDto;
import com.neuqsoft.qrcode.Essc.dto.GrcodeDTO;
import com.neuqsoft.qrcode.Essc.dto.SscicCardRspDTO;
import com.neuqsoft.qrcode.util.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class EsscService {
    @Value("${essc.country.channelNo}")
    private String channelNo;

    @Value("${essc.country.url}")
    private String callUrl;

    @Value("${essc.applySign:0}")
    private String applySign;

    @Autowired
    @Qualifier("GGFWRestTemplate")
    RestTemplate restTemplate;

    // 部平台解析二维码和认证接口 开始

    public GrcodeDTO getQrcode(String qrCode, String busiType) {
        Map<String, String> map = new HashMap<>();
        map.put("qrCode", qrCode);
        map.put("busiType", busiType);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, headers);
        return new RestTemplate().exchange(callUrl + "ecard/v1/qrcode/valid", HttpMethod.POST, httpEntity, GrcodeDTO.class).getBody();
    }

    // 省卡平台提供的电子社保卡解析 开始

    @Autowired
    private EsscSbkClient esscSbkClient;

    public SscicCardRspDTO getSscicCard(String eleSicardNo) {
        return esscSbkClient.getSscicCard(eleSicardNo);
    }

    public EsscOpenQrInfo getOpenQrInfo(String qrCode, String busiType) {
        EsscOpenQrInfo dto = new EsscOpenQrInfo();
        GrcodeDTO qrInfo = getQrcode(qrCode, busiType);
        System.out.println("部平台解析二维码和认证接口返回值:" + qrInfo.getResult());
        if (qrInfo.getResult() == null) {
            throw new GlobalException("SOURCE_ESSC" + qrInfo.getMsgCode(), qrInfo.getMsg());
        }
        System.out.println(qrInfo.getResult());
        BeanUtils.copyProperties(qrInfo.getResult(), dto);
        SscicCardRspDTO sscicCard = getSscicCard(dto.getEsscNo());
        if (sscicCard != null) {
            BeanUtils.copyProperties(sscicCard.getBusiData(), dto);
        }
        return dto;
    }

    public String getQrInfo(String qrCode, String busiType) {
        EsscOpenQrInfo open = getOpenQrInfo(qrCode, busiType);

        EsscQrcodeDto esscQrcodeDto = new EsscQrcodeDto();
        BeanUtils.copyProperties(open, esscQrcodeDto);

        String sign = RSAUtils.encrypt(esscQrcodeDto);
        System.out.println("加密字符串:" + sign);
        return sign;
    }


}
