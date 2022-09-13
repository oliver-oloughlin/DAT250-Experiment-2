package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer limit;
    private Integer balance;
    @OneToOne
    private Pincode pincode;
    @ManyToOne
    private Bank owningBank;

    public Integer getNumber() {
        return this.number;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Pincode getPincode() {
        return this.pincode;
    }

    public Bank getOwningBank() {
        return this.owningBank;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }
}
