
package model;

public class PremiumAccount extends Account implements Premium {
    public PremiumAccount(String name, long balance, double rate) {
        super(name, balance, rate);
    }
}
