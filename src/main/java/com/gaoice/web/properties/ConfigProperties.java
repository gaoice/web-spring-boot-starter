package com.gaoice.web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoice
 */
@Data
@Configuration
@ConfigurationProperties("web")
public class ConfigProperties {

    private boolean returnRTime = false;

}
