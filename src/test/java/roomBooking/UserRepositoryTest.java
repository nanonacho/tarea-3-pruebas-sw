package roomBooking;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;


public class UserRepositoryTest {
	private UserRepository repository;
	private User user;

	@BeforeEach
    public void setUp() throws Exception {
        repository = new UserRepository();
        user =  new User("John", "Informática", "description");
	}
	
	@Test
	public void testSetUsers() {
		// Given
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        this.user.setId(1);
        users.put(this.user.getId(), this.user);

        // When
        this.repository.setUsers(users);

        // Then
        assertTrue(users.get(1).equalValues(this.repository.getUsers().get(1)));
    }
	
	@Test
	public void testGetUsers() {
		// Given
		HashMap<Integer, User> users = new HashMap<Integer, User>();
		this.user.setId(1);
		users.put(this.user.getId(), this.user);
		this.repository.setUsers(users);

		// When
		HashMap<Integer, User> result = this.repository.getUsers();

		// Then
		assertTrue(result.get(1).equalValues(users.get(1)));
	}
	
	@Test
	public void testGetUserById() {
		// Given
		HashMap<Integer, User> users = new HashMap<Integer, User>();
		this.user.setId(1);
		users.put(this.user.getId(), this.user);
		this.repository.setUsers(users);

		// When
		User result = this.repository.getUserById(1);

		// Then
		assertTrue(result.equalValues(this.user));
	}
	
	@Test
	public void testGetUserByIdNotFound() {
		// Given

		// When
		User result = this.repository.getUserById(1);
		
		// Then
		assertNull(result);
	}
	
	@Test
	public void testCreateUser() {
		// Given

		// When
		User createdUser = this.repository.createUser(user);

		// Then
		assertTrue(createdUser.equalValues(user));
	}
	
	@Test
	public void testUpdateUser() {
		// Given
		User createdUser = this.repository.createUser(user);

		// When
		User userToUpdate = new User(1, "Jane", "Matemáticas", "description2");
		User updatedUser = this.repository.updateUser(userToUpdate);

		// Then
		assertTrue(!createdUser.equalValues(updatedUser));
		assertTrue(updatedUser.equalValues(userToUpdate));
	}
	
	@Test
	public void testUpdateUserNotFound() {
		// Given
		this.user.setId(1);
		
		// When
		User updatedUser = this.repository.updateUser(this.user);
		
		// Then
		assertNull(updatedUser);
	}
	
	@Test
	public void testDeleteUser() {
		// Given
		User createdUser = this.repository.createUser(user);

		// When
	    User deletedUser = this.repository.deleteUser(createdUser.getId());
	    
		// Then
	    assertTrue(deletedUser.equalValues(createdUser));
		assertNull(this.repository.getUsers().get(createdUser.getId()));
	}
	
	@Test
	public void testDeleteUserNotFound() {
		// Given
		this.user.setId(1);

		// When
		User deletedUser = this.repository.deleteUser(1);
		
		// Then
		assertNull(deletedUser);
	}
	
}
