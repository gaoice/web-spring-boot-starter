package com.gaoice.web.advice;

import com.gaoice.web.properties.ConfigProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoice
 */
@Configuration
public class WebAdviceConfig {

    private final ConfigProperties properties;

    public WebAdviceConfig(ConfigProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public WebExceptionAdvice webExceptionAdvice() {
        if (properties.isReturnRTime()) {
            return new WebExceptionRTimeAdvice();
        }
        return new WebExceptionRAdvice();
    }
}
