package com.etf.nbp.controllers;

import com.etf.nbp.dto.PaymentRequestDTO;
import com.etf.nbp.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Calls service method to create payment intent for Stripe
     * @param paymentInfo {@link PaymentRequestDTO} necessary payment information for creating intent
     * @return {@link ResponseEntity} with created intent
     * @throws StripeException
     */
    @PostMapping("/api/auth/payment-intent")
    public ResponseEntity<?> createPaymentIntent(@RequestBody PaymentRequestDTO paymentInfo) throws StripeException {
        return ResponseEntity.ok(paymentService.createPaymentIntent(paymentInfo));
    }
}
