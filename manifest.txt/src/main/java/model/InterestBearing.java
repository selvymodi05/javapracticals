
package model;

public interface InterestBearing {
    double interestRate();

    long balance();

    default double yearlyInterest() {
        return balance() * interestRate();
    }
}
