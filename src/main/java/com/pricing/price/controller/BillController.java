package com.pricing.price.controller;

import com.pricing.price.model.BillRequest;
import com.pricing.price.model.BillResponse;
import com.pricing.price.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pricing")
public class BillController {

    @Autowired
    private PricingService pricingService;

    @PostMapping("/calculate-bill")
    public ResponseEntity<BillResponse> getBill(@RequestBody BillRequest request) {
        try {
            BillResponse response = pricingService.generateBill(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            // Agar product ID galat ho to bad request return karega
            return ResponseEntity.badRequest().body(null);
        }
    }
}