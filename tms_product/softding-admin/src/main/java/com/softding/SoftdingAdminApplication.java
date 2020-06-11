package com.softding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SoftdingAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftdingAdminApplication.class, args);
        log.warn("项目启动成功!");
    }

}
