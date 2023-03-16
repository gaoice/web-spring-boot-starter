package com.gaoice.web.spring.boot.auto;

import com.gaoice.web.exception.WebExceptionConfig;
import com.gaoice.web.redis.RedisConfig;
import org.springframework.context.annotation.Import;

/**
 * @author gaoice
 */
@Import({WebExceptionConfig.class,
        RedisConfig.class})
public class WebAutoConfiguration {
}
