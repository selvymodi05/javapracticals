
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import static java.lang.System.out;

import model.*;
import service.BankService;
import util.WithdrawRule;
import exception.*;

class BankResource implements AutoCloseable {
    public BankResource() {
        out.println("Bank resource opened.");
    }

    @Override
    public void close() {
        out.println("Bank resource closed.");
    }
}

public class MiniBank {
    static void saveAccounts(ArrayList<Account> accounts) {
        try (ObjectOutputStream outFile =
                 new ObjectOutputStream(
                     new FileOutputStream("accounts.dat"))) {
            outFile.writeObject(accounts);
            out.println("Accounts saved successfully.");
        } catch (IOException e) {
            out.println("Save failed: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    static ArrayList<Account> loadAccounts() {
        try (ObjectInputStream in =
                 new ObjectInputStream(
                     new FileInputStream("accounts.dat"))) {
            ArrayList<Account> accounts =
                (ArrayList<Account>) in.readObject();

            out.println("Accounts loaded successfully.");
            return accounts;
        } catch (IOException | ClassNotFoundException e) {
            out.println("Load failed: " + e.getMessage());
            return new ArrayList<>();
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

        WithdrawRule lambdaRule = (account, amount) ->
            amount > 0 && amount <= account.balance();

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

            try {
                int choice = Integer.parseInt(sc.nextLine());

                try {
                    switch (choice) {
                        case 1:
                            for (Account a : bank.getAccounts()) {
                                out.println(a);
                            }
                            break;

                        case 2: {
                            out.print("Account name: ");
                            Account a = bank.findAccount(sc.nextLine());

                            out.print("Amount: ");
                            long amount = Long.parseLong(sc.nextLine());

                            a.deposit(amount);
                            out.println("Deposit successful.");
                            break;
                        }

                        case 3: {
                            out.print("Account name: ");
                            Account a = bank.findAccount(sc.nextLine());

                            out.print("Amount: ");
                            long amount = Long.parseLong(sc.nextLine());

                            a.withdraw(amount);
                            out.println("Withdrawal successful.");
                            break;
                        }

                        case 4: {
                            out.print("Source account: ");
                            Account from = bank.findAccount(sc.nextLine());

                            out.print("Destination account: ");
                            Account to = bank.findAccount(sc.nextLine());

                            out.print("Amount: ");
                            long amount = Long.parseLong(sc.nextLine());

                            bank.transfer(from, to, amount);
                            out.println("Transfer successful.");
                            break;
                        }

                        case 5: {
                            out.print("Account name: ");
                            Account a = bank.findAccount(sc.nextLine());

                            out.println(
                                "Yearly interest: " + a.yearlyInterest()
                            );
                            break;
                        }

                        case 6: {
                            out.print("Account name: ");
                            Account a = bank.findAccount(sc.nextLine());

                            out.print("Amount: ");
                            long amount = Long.parseLong(sc.nextLine());

                            out.println(
                                "Anonymous rule: " +
                                anonymousRule.allow(a, amount)
                            );

                            out.println(
                                "Lambda rule: " +
                                lambdaRule.allow(a, amount)
                            );
                            break;
                        }

                        case 7:
                            saveAccounts(
                                new ArrayList<>(bank.getAccounts())
                            );
                            break;

                        case 8:
                            for (Account a : loadAccounts()) {
                                out.println(a);
                            }
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
                } catch (ArithmeticException e) {
                    out.println("Error: Amount is too large.");
                } finally {
                    out.println("Operation completed.");
                }

            } catch (NumberFormatException e) {
                out.println("Please enter a valid menu number.");
            }
        }
    }
}
