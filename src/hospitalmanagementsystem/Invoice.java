package hospitalmanagementsystem;

import java.io.Serializable;

public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private float amount;
    private String payment_method;
    private String phone;
    private String gender;
    public Invoice(String p_name,String phone, String gender, float amount, String payment_method) {
        this.name = p_name;
        this.amount = amount;
        this.payment_method = payment_method;
        this.phone = phone;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPayment_method() {
        return this.payment_method;
    }

    @Override
    public String toString() {
        return new StringBuffer("Name: ").append(this.name).append("Phone Number:").append(this.phone).append("Gender").append(this.gender).append("Amount: ").append(this.amount).append("Payment Type: ").append(this.payment_method).toString();
    }
}
