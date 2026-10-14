
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import model.Account;
import service.BankService;
import exception.*;

public class BankServiceTest {

    @Test
    void depositIncreasesBalance() throws Exception {
        Account a = new Account("Test", 1000, 0.05);

        a.deposit(500);

        assertEquals(1500, a.balance());
    }

    @Test
    void withdrawalDecreasesBalance() throws Exception {
        Account a = new Account("Test", 1000, 0.05);

        a.withdraw(300);

        assertEquals(700, a.balance());
    }

    @Test
    void negativeDepositThrowsException() {
        Account a = new Account("Test", 1000, 0.05);

        assertThrows(
            InvalidAmountException.class,
            () -> a.deposit(-100)
        );
    }

    @Test
    void insufficientFundsReportsShortfall() {
        Account a = new Account("Test", 500, 0.05);

        InsufficientFundsException e = assertThrows(
            InsufficientFundsException.class,
            () -> a.withdraw(800)
        );

        assertEquals(300, e.getShortfall());
        assertEquals(500, a.balance());
    }

    @Test
    void transferUpdatesBothBalances() throws Exception {
        Account a = new Account("A", 1000, 0.05);
        Account b = new Account("B", 500, 0.05);

        BankService bank = new BankService();
        bank.transfer(a, b, 200);

        assertEquals(800, a.balance());
        assertEquals(700, b.balance());
    }

    @Test
    void unknownAccountThrowsException() {
        BankService bank = new BankService();

        assertThrows(
            AccountNotFoundException.class,
            () -> bank.findAccount("Unknown")
        );
    }
}
