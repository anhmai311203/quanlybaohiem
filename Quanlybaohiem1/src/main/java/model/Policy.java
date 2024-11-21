package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Policy {
    private int policyID;
    private String policyName;
    private BigDecimal coverageAmount;
    private BigDecimal premiumAmount;
    private int duration; // Duration in months
    private int serviceID;
    private LocalDateTime createdAt;

    // Constructor
    public Policy(int policyID, String policyName, BigDecimal coverageAmount, BigDecimal premiumAmount, int duration, int serviceID, LocalDateTime createdAt) {
        this.policyID = policyID;
        this.policyName = policyName;
        this.coverageAmount = coverageAmount;
        this.premiumAmount = premiumAmount;
        this.duration = duration;
        this.serviceID = serviceID;
        this.createdAt = createdAt;
    }

    // Getter và Setter cho policyID
    public int getPolicyID() {
        return policyID;
    }

    public void setPolicyID(int policyID) {
        this.policyID = policyID;
    }

    // Getter và Setter cho policyName
    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    // Getter và Setter cho coverageAmount
    public BigDecimal getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(BigDecimal coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    // Getter và Setter cho premiumAmount
    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    // Getter và Setter cho duration
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Getter và Setter cho serviceID
    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    // Getter và Setter cho createdAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
