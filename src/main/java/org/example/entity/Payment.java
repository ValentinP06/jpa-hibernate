package org.example.entity;


import javax.persistence.*;

@Entity
@Table (name ="payments")
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cardNumber;
    private String confidentialCode;
    private String bank;

    public Payment(long id, String cardNumber, String confidentialCode, String bank) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.confidentialCode = confidentialCode;
        this.bank = bank;
    }

    public Payment() {

    }

    public Payment(String bank) {
        this.bank = bank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getConfidentialCode() {
        return confidentialCode;
    }

    public void setConfidentialCode(String confidentialCode) {
        this.confidentialCode = confidentialCode;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", confidentialCode='" + confidentialCode + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }

    public void setNotNullDataPayment(Payment newPaymentData) {
        if (newPaymentData.getBank() != null) {
            this.setBank(newPaymentData.getBank());
        }
        if (newPaymentData.getCardNumber() != null) {
            this.setCardNumber(newPaymentData.getCardNumber());
        }
        if (newPaymentData.getConfidentialCode() != null) {
            this.setConfidentialCode(newPaymentData.getConfidentialCode());
        }

    }
}
