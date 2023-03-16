package com.gaoice.web.oplog;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author gaoice
 */
@Data
@EnableAsync(proxyTargetClass = true)
@Configuration
@ConfigurationProperties("oplog")
public class OplogConfig {

    private String threadNamePrefix = "oplog-";

    private int corePoolSize = 1;

    private int maxPoolSize = Integer.MAX_VALUE;

    private int queueCapacity = Integer.MAX_VALUE;

    private int keepAliveSeconds = 60;

    @Bean
    @ConditionalOnMissingBean(name = {"oplogExecutor"})
    public Executor oplogExecutor() {
        ThreadPoolTaskExecutor e = new ThreadPoolTaskExecutor();
        e.setThreadNamePrefix(threadNamePrefix);
        e.setCorePoolSize(corePoolSize);
        e.setMaxPoolSize(maxPoolSize);
        e.setQueueCapacity(queueCapacity);
        e.setKeepAliveSeconds(keepAliveSeconds);
        return e;
    }

    @Bean
    @ConditionalOnMissingBean
    public OplogService oplogService() {
        return new DefaultOplogService();
    }
}
