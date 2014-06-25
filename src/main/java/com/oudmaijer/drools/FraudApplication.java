package com.oudmaijer.drools;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.oudmaijer.drools.config.DroolsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@EnableSwagger
@Import({DroolsConfig.class})
public class FraudApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FraudApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class, args);
    }
}