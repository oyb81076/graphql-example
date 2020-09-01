package com.idea.graphqls.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("api")
public class ApiProperties {
    SnowflakeProperty snowflake = new SnowflakeProperty();

    @Data
    public static class SnowflakeProperty {
        long dataCenterId;
        long workerId;
    }
}

