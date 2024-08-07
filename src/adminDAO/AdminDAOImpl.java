package adminDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/oracle";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public void createAdmin(Admin admin) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO admin (adminId, password) VALUES (?, ?)")) {
            stmt.setString(1, admin.getAdminId());
            stmt.setString(2, admin.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Admin getAdmin(String adminId) {
        Admin admin = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE adminId = ?")) {
            stmt.setString(1, adminId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                admin = new Admin(rs.getString("adminId"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public void updateAdmin(Admin admin) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE admin SET password = ? WHERE adminId = ?")) {
            stmt.setString(1, admin.getPassword());
            stmt.setString(2, admin.getAdminId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAdmin(String adminId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM admin WHERE adminId = ?")) {
            stmt.setString(1, adminId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM admin")) {
            while (rs.next()) {
                Admin admin = new Admin(rs.getString("adminId"), rs.getString("password"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }
}

