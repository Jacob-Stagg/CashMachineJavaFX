package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public final class AccountData {

    private final int id;
    private final String name;
    private final String email;

    private final float balance;

    AccountData(int id, String name, String email, float balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        if (balance > -1000f && balance < 0f) {
            return "Account id: " + id + '\n' +
                    "Name: " + name + '\n' +
                    "Email: " + email + '\n' +
                    "Balance: " + balance + '\n' +
                    "Your account has an overdraft of $" + balance + "." +
                    "\nIf your overdraft reaches $-1000, " + "you will no longer" +
                    " be able to withdraw from this account.";
        } else {
            return "Account id: " + id + '\n' +
                    "Name: " + name + '\n' +
                    "Email: " + email + '\n' +
                    "Balance: " + balance;
        }
    }
}
