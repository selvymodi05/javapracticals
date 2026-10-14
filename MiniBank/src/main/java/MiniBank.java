import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.Account;
import model.PremiumAccount;
import service.BankService;
import util.WithdrawRule;
import exception.BankException;

import static java.lang.System.out;

public class MiniBank {
    private static final String DATA_FILE = "accounts.dat";

    static class BankResource implements AutoCloseable {
        BankResource() {
            out.println("Bank resource opened.");
        }

        @Override
        public void close() {
            out.println("Bank resource closed.");
        }
    }

    private static void saveAccounts(BankService bank) {
        try (ObjectOutputStream outFile =
                 new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outFile.writeObject(new ArrayList<>(bank.getAccounts()));
            out.println("Accounts saved successfully.");
        } catch (IOException e) {
            out.println("Save failed: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadAccounts(BankService bank) {
        try (ObjectInputStream in =
                 new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            ArrayList<Account> accounts = (ArrayList<Account>) in.readObject();
            bank.replaceAccounts(accounts);
            out.println("Accounts loaded successfully.");
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            out.println("Load failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        bank.addAccount(new Account("Selvy", 5000, 0.05));
        bank.addAccount(new PremiumAccount("Aman", 8000, 0.07));

        WithdrawRule anonymousRule = new WithdrawRule() {
            @Override
            public boolean allow(Account account, long amount) {
                return amount > 0 && amount <= account.balance();
            }
        };
        WithdrawRule lambdaRule =
            (account, amount) -> amount > 0 && amount <= account.balance();

        while (true) {
            out.println("\n===== MINIBANK =====");
            out.println("1. Show accounts");
            out.println("2. Deposit");
            out.println("3. Withdraw");
            out.println("4. Transfer");
            out.println("5. Calculate yearly interest");
            out.println("6. Test withdrawal rules");
            out.println("7. Save accounts");
            out.println("8. Load accounts");
            out.println("9. Try-with-resources demo");
            out.println("10. Exit");
            out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                out.println("Please enter a valid menu number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        for (Account account : bank.getAccounts()) {
                            out.println(account);
                        }
                        break;
                    case 2: {
                        out.print("Account name: ");
                        Account account = bank.findAccount(sc.nextLine().trim());
                        out.print("Amount: ");
                        long amount = Long.parseLong(sc.nextLine().trim());
                        account.deposit(amount);
                        out.println("Deposit successful.");
                        break;
                    }
                    case 3: {
                        out.print("Account name: ");
                        Account account = bank.findAccount(sc.nextLine().trim());
                        out.print("Amount: ");
                        long amount = Long.parseLong(sc.nextLine().trim());
                        account.withdraw(amount);
                        out.println("Withdrawal successful.");
                        break;
                    }
                    case 4: {
                        out.print("Source account: ");
                        Account from = bank.findAccount(sc.nextLine().trim());
                        out.print("Destination account: ");
                        Account to = bank.findAccount(sc.nextLine().trim());
                        out.print("Amount: ");
                        long amount = Long.parseLong(sc.nextLine().trim());
                        bank.transfer(from, to, amount);
                        out.println("Transfer successful.");
                        break;
                    }
                    case 5: {
                        out.print("Account name: ");
                        Account account = bank.findAccount(sc.nextLine().trim());
                        out.printf("Yearly interest: %.2f%n",
                                   account.yearlyInterest());
                        break;
                    }
                    case 6: {
                        out.print("Account name: ");
                        Account account = bank.findAccount(sc.nextLine().trim());
                        out.print("Amount: ");
                        long amount = Long.parseLong(sc.nextLine().trim());
                        out.println("Anonymous rule: " +
                                    anonymousRule.allow(account, amount));
                        out.println("Lambda rule: " +
                                    lambdaRule.allow(account, amount));
                        break;
                    }
                    case 7:
                        saveAccounts(bank);
                        break;
                    case 8:
                        loadAccounts(bank);
                        break;
                    case 9:
                        try (BankResource resource = new BankResource()) {
                            out.println("Performing bank operation.");
                            throw new RuntimeException("Demo exception");
                        } catch (RuntimeException e) {
                            out.println("Caught: " + e.getMessage());
                        }
                        break;
                    case 10:
                        out.println("Thank you for using MiniBank.");
                        sc.close();
                        return;
                    default:
                        out.println("Invalid choice.");
                }
            } catch (BankException | NumberFormatException e) {
                out.println("Error: " + e.getMessage());
            } finally {
                out.println("Operation completed.");
            }
        }
    }
}
