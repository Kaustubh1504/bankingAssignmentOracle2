package userDAO;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAOImpl();
		
		User u = new User("1234", "1234", "1234");		
		
		dao.createUser(u);

	}

}
