package model;

import java.io.Serializable;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

public class Account implements Transactable, InterestBearing, Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private long balance;
    private final double rate;

    public Account(String name, long balance, double rate) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Account name cannot be empty.");
        }
        if (balance < 0 || rate < 0) {
            throw new IllegalArgumentException("Balance and rate cannot be negative.");
        }
        this.name = name.trim();
        this.balance = balance;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    @Override
    public long balance() {
        return balance;
    }

    @Override
    public double interestRate() {
        return rate;
    }

    @Override
    public void deposit(long amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        try {
            balance = Math.addExact(balance, amount);
        } catch (ArithmeticException e) {
            throw new InvalidAmountException("Deposit exceeds the maximum balance.");
        }
    }

    @Override
    public void withdraw(long amount)
            throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
    }

    public void creditTransfer(long amount) throws InvalidAmountException {
        deposit(amount);
    }

    @Override
    public String toString() {
        return name + " | Balance: " + balance + " | Interest rate: " + rate;
    }
}
