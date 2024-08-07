package accountDAO;

public class Account {
    private String userId;
    private String accountNumber;

    public Account(String userId, String accountNumber) {
        this.userId = userId;
        this.accountNumber = accountNumber;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
