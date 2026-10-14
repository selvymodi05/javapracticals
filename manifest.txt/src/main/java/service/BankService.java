
package service;

import java.util.ArrayList;
import java.util.List;
import model.Account;
import exception.*;
import util.WithdrawRule;

public class BankService {
    private final ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public Account findAccount(String name) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getName().equalsIgnoreCase(name)) {
                return account;
            }
        }

        throw new AccountNotFoundException(
            "Account not found: " + name
        );
    }

    public void transfer(Account from, Account to, long amount)
            throws BankException {
        try {
            if (from == null || to == null) {
                throw new AccountNotFoundException(
                    "Source or destination account not found."
                );
            }

            if (from == to) {
                throw new BankException(
                    "Cannot transfer to the same account."
                );
            }

            from.withdraw(amount);
            to.creditTransfer(amount);

        } catch (BankException e) {
            throw e;
        } catch (ArithmeticException e) {
            throw new BankException("Amount exceeds the allowed balance.");
        } finally {
            System.out.println("Transfer attempt completed.");
        }
    }

    public boolean checkWithdrawal(
            Account account, long amount, WithdrawRule rule) {
        return rule.allow(account, amount);
    }
}
