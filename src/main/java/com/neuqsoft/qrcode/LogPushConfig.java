package com.neuqsoft.qrcode;

import com.neuqsoft.commons.spring.log.push.LogPushService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${app.graylog.state:false}")
public class LogPushConfig {

    @Value("${app.graylog.url}")
    private String graylogUrl;

    @Bean
    public LogPushService logPushService() {
        LogPushService logPushService = new LogPushService();
        logPushService.setGraylogUrl(graylogUrl);
        return logPushService;
    }

}
