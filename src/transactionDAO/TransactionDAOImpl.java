package transactionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/oracle";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public void createTransaction(Transaction transaction) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO transaction (transferId, source, toAccount, amount, dateOfTransfer, type, remarks) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, transaction.getTransferId());
            stmt.setString(2, transaction.getSource());
            stmt.setString(3, transaction.getToAccount());
            stmt.setDouble(4, transaction.getAmount());
            stmt.setDate(5, Date.valueOf(transaction.getDateOfTransfer()));
            stmt.setString(6, transaction.getType());
            stmt.setString(7, transaction.getRemarks());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transaction getTransaction(String transferId) {
        Transaction transaction = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM transaction WHERE transferId = ?")) {
            stmt.setString(1, transferId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                transaction = new Transaction(
                    rs.getString("transferId"),
                    rs.getString("source"),
                    rs.getString("toAccount"),
                    rs.getDouble("amount"),
                    rs.getDate("dateOfTransfer").toLocalDate(),
                    rs.getString("type"),
                    rs.getString("remarks")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE transaction SET source = ?, toAccount = ?, amount = ?, dateOfTransfer = ?, type = ?, remarks = ? WHERE transferId = ?")) {
            stmt.setString(1, transaction.getSource());
            stmt.setString(2, transaction.getToAccount());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setDate(4, Date.valueOf(transaction.getDateOfTransfer()));
            stmt.setString(5, transaction.getType());
            stmt.setString(6, transaction.getRemarks());
            stmt.setString(7, transaction.getTransferId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransaction(String transferId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM transaction WHERE transferId = ?")) {
            stmt.setString(1, transferId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM transaction")) {
            while (rs.next()) {
                Transaction transaction = new Transaction(
                    rs.getString("transferId"),
                    rs.getString("source"),
                    rs.getString("toAccount"),
                    rs.getDouble("amount"),
                    rs.getDate("dateOfTransfer").toLocalDate(),
                    rs.getString("type"),
                    rs.getString("remarks")
                );
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
