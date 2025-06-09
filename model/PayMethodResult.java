package model;

import payment.PaymentMethod;

public class PayMethodResult {
    private boolean success;
    private String message;

    private PaymentMethod method;

    public PayMethodResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public PayMethodResult(boolean success, String message, PaymentMethod method) {
        this.success = success;
        this.message = message;
        this.method = method;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public PaymentMethod getMethod() {
        return method;
    }
}
