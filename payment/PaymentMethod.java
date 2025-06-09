package payment;

import constants.PaymentType;

import java.math.BigDecimal;

public interface PaymentMethod {
    // just an abstraction that represents anyway to pay... I don't care how it's done, I just care that it can be made

    default boolean isValid() {
        return true;
    }
    boolean authorize(BigDecimal amount);
    String getMaskedDetails();
    PaymentType getType();

}
