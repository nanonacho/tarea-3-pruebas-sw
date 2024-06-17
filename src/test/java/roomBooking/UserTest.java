package roomBooking;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
	private User user;

	@BeforeEach
	public void setUp() throws Exception {
		user = new User(1, "John", "Informática", "description");
	}

	@Test
	public void testGetId() {
		// Given

		// When
		int result = this.user.getId();

		// Then
		assertEquals(1, result);
	}

	@Test
	public void testGetName() {
		// Given

		// When
		String result = this.user.getName();

		// Then
		assertEquals("John", result);
	}

	@Test
	public void testGetDepartment() {
		// Given

		// When
		String result = this.user.getDepartment();

		// Then
		assertEquals("Informática", result);
	}

	@Test
	public void testGetDescription() {
		// Given

		// When
		String result = this.user.getDescription();

		// Then
		assertEquals("description", result);
	}

	@Test
	public void testSetId() {
		// Given

		// When
		this.user.setId(2);

		// Then
		assertEquals(2, this.user.getId());
	}

	@Test
	public void testSetName() {
		// Given

		// When
		this.user.setName("Alice");

		// Then
		assertEquals("Alice", this.user.getName());
	}

	@Test
	public void testSetDepartment() {
		// Given

		// When
		this.user.setDepartment("Matemáticas");

		// Then
		assertEquals("Matemáticas", this.user.getDepartment());
	}

	@Test
	public void testSetDescription() {
		// Given

		// When
		this.user.setDescription("new description");

		// Then
		assertEquals("new description", this.user.getDescription());
	}
}
