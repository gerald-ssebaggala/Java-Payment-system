package model;

import constants.Role;
import payment.PaymentMethod;

import java.util.List;

public abstract class User {
    private String id;
    private String name;
    private String email;
    private Role role;
    private List<PaymentMethod> paymentMethods;  // my user can have multiple paymentMethods

    public PayMethodResult addPaymentMethod(PaymentMethod method) {

        if (method == null) { // validating that method ain't null
            return new PayMethodResult(false, "Sorry Payment method cannot be null.", null);
        }

        // checking if method already added--- by id or masked details
        for (PaymentMethod existing: this.paymentMethods) {
            if (existing.getMaskedDetails().equalsIgnoreCase(method.getMaskedDetails())) {
                return new PayMethodResult(false, "Duplicate payment method.", method);
            }
        }

        this.paymentMethods.add(method);
        return new PayMethodResult(true, "Payment method added successfully.", method);
    }

    public PayMethodResult removePaymentMethod (PaymentMethod method) {
        if (this.paymentMethods.contains(method)) {
            this.paymentMethods.remove(method);
        }

        return new PayMethodResult(true, "Payment method removed successfully");
    }
    public abstract void displayDashboard();
}
