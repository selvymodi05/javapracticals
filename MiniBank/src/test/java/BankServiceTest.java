import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import model.Account;
import service.BankService;
import exception.AccountNotFoundException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

public class BankServiceTest {
    @Test
    void depositIncreasesBalance() throws Exception {
        Account account = new Account("Test", 1000, 0.05);
        account.deposit(500);
        assertEquals(1500, account.balance());
    }

    @Test
    void withdrawalDecreasesBalance() throws Exception {
        Account account = new Account("Test", 1000, 0.05);
        account.withdraw(300);
        assertEquals(700, account.balance());
    }

    @Test
    void invalidDepositThrowsException() {
        Account account = new Account("Test", 1000, 0.05);
        assertThrows(InvalidAmountException.class, () -> account.deposit(0));
    }

    @Test
    void insufficientFundsContainsShortfall() {
        Account account = new Account("Test", 500, 0.05);
        InsufficientFundsException error = assertThrows(
            InsufficientFundsException.class, () -> account.withdraw(800));
        assertEquals(300, error.getShortfall());
        assertEquals(500, account.balance());
    }

    @Test
    void transferUpdatesBothBalances() throws Exception {
        Account from = new Account("A", 1000, 0.05);
        Account to = new Account("B", 500, 0.05);
        BankService bank = new BankService();
        bank.transfer(from, to, 200);
        assertEquals(800, from.balance());
        assertEquals(700, to.balance());
    }

    @Test
    void unknownAccountThrowsException() {
        BankService bank = new BankService();
        assertThrows(AccountNotFoundException.class,
            () -> bank.findAccount("Unknown"));
    }
}
