
package model;

import java.io.Serializable;
import exception.*;

public class Account implements Transactable, InterestBearing, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private long balance;
    private double rate;

    public Account(String name, long balance, double rate) {
        if (balance < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid account details.");
        }

        this.name = name;
        this.balance = balance;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public long balance() {
        return balance;
    }

    public double interestRate() {
        return rate;
    }

    public void deposit(long amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be positive."
            );
        }

        balance = Math.addExact(balance, amount);
    }

    public void withdraw(long amount)
            throws InsufficientFundsException, InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be positive."
            );
        }

        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }

        balance -= amount;
    }

    public void creditTransfer(long amount)
            throws InvalidAmountException {
        deposit(amount);
    }

    public String toString() {
        return name + " | Balance: " + balance;
    }
}

interface Transactable {
    void deposit(long amount) throws InvalidAmountException;

    void withdraw(long amount)
        throws InsufficientFundsException, InvalidAmountException;
}

interface InterestBearing {
    double interestRate();

    long balance();

    default double yearlyInterest() {
        return balance() * interestRate();
    }
}
