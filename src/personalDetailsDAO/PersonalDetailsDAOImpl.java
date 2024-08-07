package personalDetailsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalDetailsDAOImpl implements PersonalDetailsDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/oracle";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public void createPersonalDetails(PersonalDetails personalDetails) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO personalDetails (userId, title, firstName, middleName, lastName, fathersName, mobile, email, aadhar, dob, addressLine1, addressLine2, landmark, state, city, pincode, occupation, sourceOfIncome, grossAnnualIncome, debitCardOpted, netBankingOpted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, personalDetails.getUserId());
            stmt.setString(2, personalDetails.getTitle());
            stmt.setString(3, personalDetails.getFirstName());
            stmt.setString(4, personalDetails.getMiddleName());
            stmt.setString(5, personalDetails.getLastName());
            stmt.setString(6, personalDetails.getFathersName());
            stmt.setString(7, personalDetails.getMobile());
            stmt.setString(8, personalDetails.getEmail());
            stmt.setString(9, personalDetails.getAadhar());
            stmt.setDate(10, Date.valueOf(personalDetails.getDob()));
            stmt.setString(11, personalDetails.getAddressLine1());
            stmt.setString(12, personalDetails.getAddressLine2());
            stmt.setString(13, personalDetails.getLandmark());
            stmt.setString(14, personalDetails.getState());
            stmt.setString(15, personalDetails.getCity());
            stmt.setString(16, personalDetails.getPincode());
            stmt.setString(17, personalDetails.getOccupation());
            stmt.setString(18, personalDetails.getSourceOfIncome());
            stmt.setString(19, personalDetails.getGrossAnnualIncome());
            stmt.setBoolean(20, personalDetails.isDebitCardOpted());
            stmt.setBoolean(21, personalDetails.isNetBankingOpted());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PersonalDetails getPersonalDetails(String userId) {
        PersonalDetails personalDetails = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM personalDetails WHERE userId = ?")) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                personalDetails = new PersonalDetails(
                    rs.getString("userId"),
                    rs.getString("title"),
                    rs.getString("firstName"),
                    rs.getString("middleName"),
                    rs.getString("lastName"),
                    rs.getString("fathersName"),
                    rs.getString("mobile"),
                    rs.getString("email"),
                    rs.getString("aadhar"),
                    rs.getDate("dob").toLocalDate(),
                    rs.getString("addressLine1"),
                    rs.getString("addressLine2"),
                    rs.getString("landmark"),
                    rs.getString("state"),
                    rs.getString("city"),
                    rs.getString("pincode"),
                    rs.getString("occupation"),
                    rs.getString("sourceOfIncome"),
                    rs.getString("grossAnnualIncome"),
                    rs.getBoolean("debitCardOpted"),
                    rs.getBoolean("netBankingOpted")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalDetails;
    }

    @Override
    public void updatePersonalDetails(PersonalDetails personalDetails) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE personalDetails SET title = ?, firstName = ?, middleName = ?, lastName = ?, fathersName = ?, mobile = ?, email = ?, aadhar = ?, dob = ?, addressLine1 = ?, addressLine2 = ?, landmark = ?, state = ?, city = ?, pincode = ?, occupation = ?, sourceOfIncome = ?, grossAnnualIncome = ?, debitCardOpted = ?, netBankingOpted = ? WHERE userId = ?")) {
            stmt.setString(1, personalDetails.getTitle());
            stmt.setString(2, personalDetails.getFirstName());
            stmt.setString(3, personalDetails.getMiddleName());
            stmt.setString(4, personalDetails.getLastName());
            stmt.setString(5, personalDetails.getFathersName());
            stmt.setString(6, personalDetails.getMobile());
            stmt.setString(7, personalDetails.getEmail());
            stmt.setString(8, personalDetails.getAadhar());
            stmt.setDate(9, Date.valueOf(personalDetails.getDob()));
            stmt.setString(10, personalDetails.getAddressLine1());
            stmt.setString(11, personalDetails.getAddressLine2());
            stmt.setString(12, personalDetails.getLandmark());
            stmt.setString(13, personalDetails.getState());
            stmt.setString(14, personalDetails.getCity());
            stmt.setString(15, personalDetails.getPincode());
            stmt.setString(16, personalDetails.getOccupation());
            stmt.setString(17, personalDetails.getSourceOfIncome());
            stmt.setString(18, personalDetails.getGrossAnnualIncome());
            stmt.setBoolean(19, personalDetails.isDebitCardOpted());
            stmt.setBoolean(20, personalDetails.isNetBankingOpted());
            stmt.setString(21, personalDetails.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePersonalDetails(String userId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM personalDetails WHERE userId = ?")) {
            stmt.setString(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PersonalDetails> getAllPersonalDetails() {
        List<PersonalDetails> personalDetailsList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM personalDetails")) {
            while (rs.next()) {
                PersonalDetails personalDetails = new PersonalDetails(
                    rs.getString("userId"),
                    rs.getString("title"),
                    rs.getString("firstName"),
                    rs.getString("middleName"),
                    rs.getString("lastName"),
                    rs.getString("fathersName"),
                    rs.getString("mobile"),
                    rs.getString("email"),
                    rs.getString("aadhar"),
                    rs.getDate("dob").toLocalDate(),
                    rs.getString("addressLine1"),
                    rs.getString("addressLine2"),
                    rs.getString("landmark"),
                    rs.getString("state"),
                    rs.getString("city"),
                    rs.getString("pincode"),
                    rs.getString("occupation"),
                    rs.getString("sourceOfIncome"),
                    rs.getString("grossAnnualIncome"),
                    rs.getBoolean("debitCardOpted"),
                    rs.getBoolean("netBankingOpted")
                );
                personalDetailsList.add(personalDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalDetailsList;
    }
}
