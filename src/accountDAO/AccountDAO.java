package accountDAO;

import java.util.List;

public interface AccountDAO {
    void createAccount(Account account);
    Account getAccount(String userId);
    void updateAccount(Account account);
    void deleteAccount(String userId);
    List<Account> getAllAccounts();
}

