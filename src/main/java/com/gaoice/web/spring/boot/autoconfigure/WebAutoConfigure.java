package com.gaoice.web.spring.boot.autoconfigure;

import com.gaoice.web.spring.boot.autoconfigure.advice.WebExceptionAdvice;
import com.gaoice.web.spring.boot.autoconfigure.advice.WebExceptionRAdvice;
import com.gaoice.web.spring.boot.autoconfigure.advice.WebExceptionRTimeAdvice;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(RedisConnectionFactory.class)
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
}
