package roomBooking;
import java.util.HashMap;

public class UserRepository {
	private HashMap<Integer, User> users;
	private int idCounter = 1;
	
	public UserRepository() {
		this.users = new HashMap<Integer, User>();
	}

	public void setUsers(HashMap<Integer, User> users) {
		this.users = users;
	}
	
	public HashMap<Integer, User> getUsers() {
		return this.users;
	}
	
	public User getUserById(int id) {
		User user = this.users.get(id);

		return user;
	}
	
	public User createUser(User user) {
		user.setId(this.idCounter++);

		this.users.put(user.getId(), user);

		return user;
	}
	
	public User deleteUser(int id) {
		User deletedUser = this.users.remove(id);

		return deletedUser;
	}
	
	public User updateUser(User user) {
		
		if (!this.users.containsKey(user.getId())) {
			return null;
		}
		
		this.users.put(user.getId(), user);
		
		return user;
	}
}
