package com.etf.nbp.services;

import com.etf.nbp.dto.PaymentRequestDTO;
import com.etf.nbp.dto.PaymentResponseDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${STRIPE_SECRET}")
    private String apiKey;

    /**
     * Creates a payment intent for Stripe which guides through the process of collecting a payment from the customer
     *
     * @param paymentInfo {@link PaymentRequestDTO} necessary payment information for creating intent
     * @return {@link PaymentResponseDTO} with client secret
     * @throws StripeException
     */
    public PaymentResponseDTO createPaymentIntent(PaymentRequestDTO paymentInfo) throws StripeException {
        Stripe.apiKey = apiKey;
        final PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount((long) (paymentInfo.getAmount() * 100))
                        .setCurrency("USD")
                        .addPaymentMethodType("card")
                        .putMetadata("product_id", paymentInfo.getProductId())
                        .build();
        final PaymentIntent paymentIntent = PaymentIntent.create(params);
        return new PaymentResponseDTO(paymentIntent.getClientSecret());
    }
}