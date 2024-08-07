package adminDAO;

import java.util.List;

public interface AdminDAO {
    void createAdmin(Admin admin);
    Admin getAdmin(String adminId);
    void updateAdmin(Admin admin);
    void deleteAdmin(String adminId);
    List<Admin> getAllAdmins();
}
