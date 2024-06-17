package roomBooking;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
	private Room room;
	
	@BeforeEach
	public void setUp() throws Exception {
		room = new Room(1, "P-101", "Edificio P");
	}
	
	@Test
	public void testGetId() {
		// Given
		
		// When
		int result = this.room.getId();
		
		// Then
		assertEquals(1, result);
	}
	
	@Test 
	public void testGetName() {
		// Given
		
		// When
		String result = this.room.getName();
		
		// Then
		assertEquals("P-101", result);
	}
	
	@Test
	public void testGetLocation() {
		// Given
		
		// When
		String result = this.room.getLocation();
		
		// Then
		assertEquals("Edificio P", result);
	}
	
	@Test
	public void testSetId() {
		// Given
		
		// When
		this.room.setId(2);
		
		// Then
		assertEquals(2, this.room.getId());
	}
	
	@Test
	public void testSetName() {
		// Given
		
		// When
		this.room.setName("C-232");
		
		// Then
		assertEquals("C-232", this.room.getName());
	}
	
	@Test
	public void testSetLocation() {
		// Given
		
		// When
		this.room.setLocation("Edificio C");
		
		// Then
		assertEquals("Edificio C", this.room.getLocation());
	}
	
}
