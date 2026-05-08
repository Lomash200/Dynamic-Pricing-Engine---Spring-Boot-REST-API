package com.pricing.price.model;

public class BillResponse {
    private String productName;
    private double originalPrice;
    private double discountAmount;
    private double taxAmount; // 18% GST standard
    private double finalPayableAmount;

    public BillResponse(String productName, double originalPrice, double discountAmount, double taxAmount, double finalPayableAmount) {
        this.productName = productName;
        this.originalPrice = originalPrice;
        this.discountAmount = discountAmount;
        this.taxAmount = taxAmount;
        this.finalPayableAmount = finalPayableAmount;
    }

    // Getters (Jackson library response conversion ke liye getters ka hona zaroori hai)
    public String getProductName() { return productName; }
    public double getOriginalPrice() { return originalPrice; }
    public double getDiscountAmount() { return discountAmount; }
    public double getTaxAmount() { return taxAmount; }
    public double getFinalPayableAmount() { return finalPayableAmount; }
}