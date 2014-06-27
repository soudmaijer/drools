package com.oudmaijer.drools.fraud;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.oudmaijer.drools.fraud.rules.Errors;
import com.oudmaijer.drools.fraud.rules.Order;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class FraudService {

    private final KieBase kbase;
    private final FraudRepository fraudRepository;
    private final GaugeService gaugeService;

    @Inject
    public FraudService(KieBase kbase, FraudRepository fraudRepository, GaugeService gaugeService) {
        this.kbase = kbase;
        this.fraudRepository = fraudRepository;
        this.gaugeService = gaugeService;
    }

    @Metered
    @ExceptionMetered
    public Errors check(Order order) {
        KieSession ksession = kbase.newKieSession();

        // Setup globals
        Errors errors = new Errors();
        addGlobalObjectsToSession(ksession, errors);

        // Add order to be validated
        ksession.insert(fraudRepository.getBlacklist());
        ksession.insert(order);

        // Fire all rules and destroy session.
        ksession.fireAllRules();
        ksession.destroy();

        // Update metrics
        gaugeService.submit("histogram.fraud.check.order", errors.getErrors().size());

        // Return result
        return errors;
    }

    private void addGlobalObjectsToSession(KieSession kieSession, Errors errors) {
        kieSession.setGlobal("errors", errors);
    }
}

