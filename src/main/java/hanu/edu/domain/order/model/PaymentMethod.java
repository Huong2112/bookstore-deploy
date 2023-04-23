package hanu.edu.domain.order.model;

import hanu.edu.domain.security.exception.BaseException;

public enum PaymentMethod {
    CASH, ONLINE;

    public static PaymentMethod of(String paymentMethod) {
        if(paymentMethod.equalsIgnoreCase("Cash")) {
            return CASH;
        } else if (paymentMethod.equalsIgnoreCase("Online")) {
            return ONLINE;
        } else {
            throw new BaseException("500", "Invalid money method");
        }
    }
}
