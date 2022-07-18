package com.gaoice.web.spring.boot.auto;

import com.gaoice.web.advice.WebAdviceConfig;
import com.gaoice.web.properties.ConfigProperties;
import com.gaoice.web.redis.RedisConfig;
import org.springframework.context.annotation.Import;

/**
 * @author gaoice
 */
@Import({ConfigProperties.class,
        WebAdviceConfig.class,
        RedisConfig.class})
public class WebAutoConfiguration {
}
