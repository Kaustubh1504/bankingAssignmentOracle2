package transactionDAO;

import java.util.List;

public interface TransactionDAO {
    void createTransaction(Transaction transaction);
    Transaction getTransaction(String transferId);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(String transferId);
    List<Transaction> getAllTransactions();
}
