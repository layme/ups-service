package com.ziroom.ups;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author
 * @create 2018-12-09 23:20
 * Description:
 */
@Slf4j
@EnableTransactionManagement
@SpringBootApplication
public class UpsServiceApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UpsServiceApplication.class, args);
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            log.info("current profile: {}", profile);
        }
    }
}
