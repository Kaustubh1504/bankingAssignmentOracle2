package BeneficiaryDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeneficiaryDAOImpl implements BeneficiaryDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/oracle";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public void createBeneficiary(Beneficiary beneficiary) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO beneficiary (beneficiaryId, source, accountNumber) VALUES (?, ?, ?)")) {
            stmt.setString(1, beneficiary.getBeneficiaryId());
            stmt.setString(2, beneficiary.getSource());
            stmt.setString(3, beneficiary.getAccountNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Beneficiary getBeneficiary(String beneficiaryId) {
        Beneficiary beneficiary = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM beneficiary WHERE beneficiaryId = ?")) {
            stmt.setString(1, beneficiaryId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                beneficiary = new Beneficiary(rs.getString("beneficiaryId"), rs.getString("source"), rs.getString("accountNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beneficiary;
    }

    @Override
    public void updateBeneficiary(Beneficiary beneficiary) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE beneficiary SET source = ?, accountNumber = ? WHERE beneficiaryId = ?")) {
            stmt.setString(1, beneficiary.getSource());
            stmt.setString(2, beneficiary.getAccountNumber());
            stmt.setString(3, beneficiary.getBeneficiaryId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBeneficiary(String beneficiaryId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM beneficiary WHERE beneficiaryId = ?")) {
            stmt.setString(1, beneficiaryId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Beneficiary> getAllBeneficiaries() {
        List<Beneficiary> beneficiaries = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM beneficiary")) {
            while (rs.next()) {
                Beneficiary beneficiary = new Beneficiary(rs.getString("beneficiaryId"), rs.getString("source"), rs.getString("accountNumber"));
                beneficiaries.add(beneficiary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beneficiaries;
    }
}
