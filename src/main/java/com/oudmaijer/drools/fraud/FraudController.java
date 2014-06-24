package com.oudmaijer.drools.fraud;

import com.oudmaijer.drools.fraud.model.Errors;
import com.oudmaijer.drools.fraud.model.Order;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Api(value = "fraud", description = "Fraud and risk service API") // Swagger annotation
@RestController
@RequestMapping("/fraud/check")
public class FraudController {

    private FraudService fraudService;

    @Inject
    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @ApiOperation("Order fraud check")
    @RequestMapping(value = "/order", method = {RequestMethod.POST})
    public Errors<String> checkOrder(@RequestBody Order order) {
        return fraudService.check(order);
    }
}
