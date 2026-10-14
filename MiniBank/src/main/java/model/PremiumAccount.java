package model;

public class PremiumAccount extends Account implements Premium {
    private static final long serialVersionUID = 1L;

    public PremiumAccount(String name, long balance, double rate) {
        super(name, balance, rate);
    }
}
