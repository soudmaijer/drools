package com.oudmaijer.drools;

import com.oudmaijer.drools.config.DroolsConfig;
import com.oudmaijer.drools.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_VIEW_RESOLVER_SUFFIX;

@Configuration
@EnableAutoConfiguration
@Import({DroolsConfig.class, SwaggerConfig.class})
public class FraudApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FraudApplication.class);
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolverJsp() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(WEB_JAR_VIEW_RESOLVER_SUFFIX);
        resolver.setOrder(0);
        return resolver;
    }

    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class, args);
    }
}