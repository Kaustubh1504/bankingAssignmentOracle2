package userDAO;

public class User {
    private String userId;
    private String password;
    private String transactionPassword;

    public User(String userId, String password, String transactionPassword) {
        this.userId = userId;
        this.password = password;
        this.transactionPassword = transactionPassword;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }
}
