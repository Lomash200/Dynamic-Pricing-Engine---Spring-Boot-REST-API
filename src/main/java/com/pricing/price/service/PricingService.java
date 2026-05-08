package com.pricing.price.service;

import com.pricing.price.model.BillRequest;
import com.pricing.price.model.BillResponse;
import com.pricing.price.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PricingService {

    // Dummy Database (In-Memory Product Store)
    private static final Map<String, Product> productDatabase = new HashMap<>();

    static {
        productDatabase.put("PROD01", new Product("PROD01", "Gaming Laptop", 60000.0));
        productDatabase.put("PROD02", new Product("PROD02", "Smart Phone", 15000.0));
        productDatabase.put("PROD03", new Product("PROD03", "Wireless Headphones", 3000.0));
    }

    public BillResponse generateBill(BillRequest request) {
        // 1. Check karo product database me hai ya nahi
        Product product = productDatabase.get(request.getProductId());
        if (product == null) {
            throw new RuntimeException("Product Not Found, Please Enter Correct Product ID!! .");
        }

        double originalPrice = product.getBasePrice();
        double discount = 0.0;

        // 2. Promo Code check karo
        if ("WELCOME100".equalsIgnoreCase(request.getPromoCode())) {
            discount = 100.0; // Flat 100 Rs off
        } else if ("FESTIVE20".equalsIgnoreCase(request.getPromoCode())) {
            discount = originalPrice * 0.20; // 20% off
        }

        // Discount base price se zyada na ho jaye
        if (discount > originalPrice) {
            discount = originalPrice;
        }

        double priceAfterDiscount = originalPrice - discount;

        // 3. Tax calculate karo (Maan lo 18% standard GST lag raha hai)
        double tax = priceAfterDiscount * 0.18;

        // 4. Final calculation
        double finalAmount = priceAfterDiscount + tax;

        return new BillResponse(
                product.getName(),
                originalPrice,
                discount,
                tax,
                finalAmount
        );
    }
}