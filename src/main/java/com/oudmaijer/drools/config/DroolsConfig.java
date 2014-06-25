package com.oudmaijer.drools.config;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.commons.io.IOUtils;
import org.drools.core.io.impl.FileSystemResource;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Stephan on 17-06-14.
 */
@Configuration
@ComponentScan(basePackages = {"com.oudmaijer.drools.fraud"})
public class DroolsConfig {

    private Resource[] listRules() throws IOException {
        PathMatchingResourcePatternResolver pmrs = new PathMatchingResourcePatternResolver();
        Resource[] resources = pmrs.getResources("classpath*:com/oudmaijer/**/*.drl");
        return resources;
    }

    @Bean
    public KieContainer kieContainer() throws IOException {
        KieServices ks = KieServices.Factory.get();
        final KieRepository kr = ks.getRepository();
        kr.addKieModule(new KieModule() {
            @Override
            public ReleaseId getReleaseId() {
                return kr.getDefaultReleaseId();
            }
        });
        KieFileSystem kfs = ks.newKieFileSystem();
        Resource[] files = listRules();

        for(Resource file : files) {
            String myString = IOUtils.toString(file.getInputStream(), "UTF-8");
            kfs.write("src/main/resources/"+ file.getFilename(), myString);
        }

        KieBuilder kb = ks.newKieBuilder(kfs);
        kb.buildAll(); // kieModule is automatically deployed to KieRepository if successfully built.
        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
        return kContainer;
    }

    @Bean
    public KieBase kieBase() throws IOException {
        KieBase kieBase = kieContainer().getKieBase();
        return kieBase;
    }
}