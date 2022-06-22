package com.gaoice.web.spring.boot.autoconfigure;

import com.gaoice.web.spring.boot.autoconfigure.advice.WebExceptionAdvice;
import com.gaoice.web.spring.boot.autoconfigure.advice.WebExceptionRAdvice;
import com.gaoice.web.spring.boot.autoconfigure.advice.WebExceptionRTimeAdvice;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoice
 */
@Data
@Configuration
@EnableConfigurationProperties(WebAutoConfigure.class)
@ConfigurationProperties("com.gaoice.web")
public class WebAutoConfigure {

    private boolean enableExRTime = false;

    @Bean
    @ConditionalOnMissingBean
    public WebExceptionAdvice webExceptionAdvice() {
        if (enableExRTime) {
            return new WebExceptionRTimeAdvice();
        }
        return new WebExceptionRAdvice();
    }
}
