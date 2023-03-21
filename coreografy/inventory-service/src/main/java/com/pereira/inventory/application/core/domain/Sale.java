package com.pereira.inventory.application.core.domain;

import com.pereira.inventory.application.core.domain.enums.SalesStatus;

import java.math.BigDecimal;

public class Sale {

    private Integer id;
    private Integer productId;
    private Integer userId;
    private BigDecimal value;
    private SalesStatus status;
    private Integer quantity;
    public Sale() {
    }
    public Sale(Integer id, Integer productId, Integer userId, BigDecimal value, SalesStatus status, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.value = value;
        this.status = status;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public SalesStatus getStatus() {
        return status;
    }

    public void setStatus(SalesStatus status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
