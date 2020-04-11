package com.neuqsoft.qrcode.Essc.service;

import com.neuqsoft.commons.spring.restful.RestTemplate406;
import com.neuqsoft.qrcode.Essc.dto.SscicCardRspDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * ----------------------------------------------
 * ${DESCRIPTION}
 * ----------------------------------------------
 *
 * @author baidh@neuqsoft.com
 * @create 2018-12-06 9:37
 * ----------------------------------------------
 */
@Component
public class EsscSbkClient {

    @Value("${medical.center.url}")
    private String centerUrl;

    public RestTemplate restTemplate() {
        return RestTemplate406.build("MSERVICE-CENTER", "电子社保卡解析出错");
    }

    public SscicCardRspDTO getSscicCard(String eleSicardNo) {
        String url=centerUrl + "api/essc/ssciccard?eleSicardNo=" + eleSicardNo;
        System.out.println("\n 获取getSscicCard的url："+url);
        SscicCardRspDTO sscicCardRspDTO= restTemplate().getForObject(url, SscicCardRspDTO.class);
        return sscicCardRspDTO;
    }

}
