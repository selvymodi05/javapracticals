package service;

import java.util.ArrayList;
import java.util.List;
import model.Account;
import exception.AccountNotFoundException;
import exception.BankException;
import exception.InvalidAmountException;
import util.WithdrawRule;

public class BankService {
    private final ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public void replaceAccounts(List<Account> newAccounts) {
        accounts.clear();
        for (Account account : newAccounts) {
            addAccount(account);
        }
    }

    public Account findAccount(String name) throws AccountNotFoundException {
        if (name != null) {
            for (Account account : accounts) {
                if (account.getName().equalsIgnoreCase(name.trim())) {
                    return account;
                }
            }
        }
        throw new AccountNotFoundException("Account not found: " + name);
    }

    public void transfer(Account from, Account to, long amount)
            throws BankException {
        try {
            if (from == null || to == null) {
                throw new AccountNotFoundException(
                    "Source or destination account not found.");
            }
            if (from == to) {
                throw new BankException("Cannot transfer to the same account.");
            }
            if (amount <= 0) {
                throw new InvalidAmountException(
                    "Transfer amount must be positive.");
            }

            // Validate destination credit before debiting the source.
            try {
                Math.addExact(to.balance(), amount);
            } catch (ArithmeticException e) {
                throw new InvalidAmountException(
                    "Transfer would exceed the destination balance limit.");
            }

            from.withdraw(amount);
            to.creditTransfer(amount);
        } catch (BankException e) {
            throw e;
        } finally {
            System.out.println("Transfer attempt completed.");
        }
    }

    public boolean checkWithdrawal(Account account, long amount, WithdrawRule rule) {
        return rule.allow(account, amount);
    }
}
