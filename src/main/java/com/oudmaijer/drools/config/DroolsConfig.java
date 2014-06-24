package com.oudmaijer.drools.config;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Stephan on 17-06-14.
 */
@Configuration
@ComponentScan(basePackages = {"com.oudmaijer.drools.fraud"})
public class DroolsConfig {

    @Bean
    public KieContainer kieContainer() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.newKieClasspathContainer();

        return kContainer;
    }

    @Bean
    public KieBase kieBase() {
        KieBase kieBase = kieContainer().getKieBase();
        return kieBase;
    }

}

