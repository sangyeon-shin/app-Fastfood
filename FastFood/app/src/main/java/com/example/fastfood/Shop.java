package com.example.fastfood;

public class Shop {
    private String classification;
    private String franchise;
    private String description;

    public Shop(String classification, String franchise, String description) {
        this.classification = classification;
        this.franchise = franchise;
        this.description = description;
    }

    public String getClassification() {
        return classification;
    }

    public String getFranchise() {
        return franchise;
    }

    public String getDescription() {
        return description;
    }
}
