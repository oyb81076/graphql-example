package com.idea.graphqls.api.beans;

import com.idea.graphqls.api.ApiProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.downgoon.snowflake.Snowflake;

@Log4j2
@Configuration
public class SnowflakeConfiguration {
    @Bean
    public Snowflake snowflake(ApiProperties properties) {
        long dataCenterId = properties.getSnowflake().getDataCenterId();
        long workerId = properties.getSnowflake().getWorkerId();
        log.info("Snowflake({},{})", dataCenterId, workerId);
        return new Snowflake(dataCenterId, workerId);
    }
}
