package com.oudmaijer.drools.fraud;

import com.oudmaijer.drools.fraud.rules.Errors;
import com.oudmaijer.drools.fraud.rules.Order;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/order", method = {RequestMethod.POST}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Errors checkOrder(@RequestBody Order order) {
        return fraudService.check(order);
    }
}
