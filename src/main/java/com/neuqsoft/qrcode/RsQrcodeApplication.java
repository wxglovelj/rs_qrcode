package com.neuqsoft.qrcode;

import com.neuqsoft.commons.spring.restful.RestTemplate406;
import com.neuqsoft.commons.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class RsQrcodeApplication {


    @Value("${app.workerId:0}")
    private long workerId;

    @Bean
    IdWorker idWorker(){
        return new IdWorker(workerId);
    }


    @Bean(name = "GGFWRestTemplate")
    @LoadBalanced
    public RestTemplate restTemplate() {
        return RestTemplate406.build("GGFW", "公共服务接口响应超时");
    }

    public static void main(String[] args) {
        SpringApplication.run(RsQrcodeApplication.class, args);
    }

}
