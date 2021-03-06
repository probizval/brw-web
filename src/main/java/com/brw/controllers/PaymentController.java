package com.brw.controllers;

import com.brw.dto.PaymentDTO;
import com.brw.service.StripeClient;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stripePayment/v1/")
public class PaymentController {

    private StripeClient stripeClient;

    @Autowired
    PaymentController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("chargeCustomer")
    public Charge chargeCard(@RequestBody  PaymentDTO paymentDTO) throws Exception {
    	
    	System.out.println("*** Inside PaymentController.chargeCard(): "+paymentDTO.getToken());
        String token = paymentDTO.getToken();
        Double amount = paymentDTO.getAmount();
        return this.stripeClient.chargeNewCard(token, amount);
    }
}
