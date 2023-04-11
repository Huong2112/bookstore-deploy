package hanu.edu.domain.order.model;

import hanu.edu.domain.security.exception.BaseException;

public enum OrderStatus {
    SUCCESS, SHIPPING, ADMIN_PREPARING, CUSTOMER_CONFIRMED, CUSTOMER_CANCELED, CUSTOMER_REQUEST_CANCEL;

    public static OrderStatus of(String orderStatus) {
        switch (orderStatus.toUpperCase()) {
            case "SUCCESS" -> {
                return SUCCESS;
            }
            case "SHIPPING" -> {
                return SHIPPING;
            }
            case "ADMIN_PREPARING" -> {
                return ADMIN_PREPARING;
            }
            case "CUSTOMER_REQUEST_CANCEL" -> {
                return CUSTOMER_REQUEST_CANCEL;
            }
            case "CONFIRMING" -> {
                return CUSTOMER_CONFIRMED;
            }
            case "CANCELED" -> {
                return CUSTOMER_CANCELED;
            }
            default -> {
                throw new BaseException("500", "Invalid order status");
            }
        }
    }
}
