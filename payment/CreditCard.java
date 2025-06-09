package payment;

import constants.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String holderName;
    private String cvv;
    private LocalDate expiry;
    private BigDecimal balance;


    public CreditCard(String cardNumber, String holderName, String cvv, LocalDate expiry, BigDecimal balance) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.cvv = cvv;
        this.expiry = expiry;
        this.balance = balance;
    }


    @Override
    public String getMaskedDetails() {
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CREDIT_CARD;
    }

    @Override
    public boolean authorize(BigDecimal amount) {
        if (!isValid()) return false;

        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            return true;
        }

        return false;
    }

    @Override
    public boolean isValid() {
        return expiry != null && expiry.isAfter(LocalDate.now());
    }
}
