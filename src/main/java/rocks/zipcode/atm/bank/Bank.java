package rocks.zipcode.atm.bank;

import rocks.zipcode.atm.ActionResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZipCodeWilmington
 */
public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();

    public Bank() {
        accounts.put(1, new BasicAccount(new AccountData(
                1, "Jacob Stagg", "StaggJ@gmail.com", 2500f
        )));

        accounts.put(2, new PremiumAccount(new AccountData(
                2, "Jacob Lee Stagg", "StaggJ@gmail.com", 3000f
        )));

        accounts.put(3, new BasicAccount(new AccountData(
                3, "Bill Bob", "BobB@gmail.com", 1500f
        )));

        accounts.put(4, new PremiumAccount(new AccountData(
                4, "Bill B Bob", "BobB@gmail.com", 2000f
        )));
    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + id + "\nTry account 1, 2, 3, or 4.");
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if (ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("Your withdraw of $" + amount + " has failed. Your account balance is $" + account.getBalance() + ".");
        }
    }
}
