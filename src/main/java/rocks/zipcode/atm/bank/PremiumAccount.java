package rocks.zipcode.atm.bank;

import javafx.scene.Parent;
import rocks.zipcode.atm.CashMachineApp;

/**
 * @author ZipCodeWilmington
 */
public class PremiumAccount extends Account {

    private static final int OVERDRAFT_LIMIT = 1000;

    public PremiumAccount(AccountData accountData) {
        super(accountData);
    }

    @Override
    protected boolean canWithdraw(float amount) {
        return getBalance() + OVERDRAFT_LIMIT >= amount;
    }
}
