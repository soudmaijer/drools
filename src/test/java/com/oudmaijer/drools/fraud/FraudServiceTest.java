package com.oudmaijer.drools.fraud;

import com.oudmaijer.drools.config.DroolsConfig;
import com.oudmaijer.drools.fraud.rules.Address;
import com.oudmaijer.drools.fraud.rules.Errors;
import com.oudmaijer.drools.fraud.rules.Order;
import com.oudmaijer.drools.fraud.rules.Seller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DroolsConfig.class)
public class FraudServiceTest {
    @Autowired
    private FraudService fraudService;
    public Logger log = LoggerFactory.getLogger(FraudServiceTest.class);

    @Test
    public void testOrderValidation() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            final boolean first = (i == 0);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Errors errors = fraudService.check(new Order("1", new Seller(3), new Address("3452RK", 53)));
                    if (first) {
                        log.info("Validated with {} errors {}", errors.getErrors().size(), errors.getErrors());
                    }
                }
            }).run();
        }
        stopWatch.stop();
        log.info("Validation of {} took: " + stopWatch.getTotalTimeMillis() + "ms");
    }
}
