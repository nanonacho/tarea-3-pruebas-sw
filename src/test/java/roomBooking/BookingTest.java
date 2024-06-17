package roomBooking;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {
	private Booking booking;
	
	@BeforeEach
	public void setUp() throws Exception {
		booking = new Booking(1, 1, 1, "16/06/2024", "Reserva para la clase de informática");
	}
	
	@Test
	public void testGetId() {
		// Given

		// When
		int result = this.booking.getId();

		// Then
		assertEquals(1, result);
	}
	
	
	@Test
	public void testGetRoomId() {
		// Given

		// When
		int result = this.booking.getRoomId();

		// Then
		assertEquals(1, result);
	}
	
	@Test
	public void testGetUserId() {
		// Given

		// When
		int result = this.booking.getUserId();

		// Then
		assertEquals(1, result);
	}
	
	@Test
	public void testGetDate() {
		// Given

		// When
		String result = this.booking.getDate();

		// Then
		assertEquals("16/06/2024", result);
	}
	
	@Test
	public void testGetDescription() {
		// Given

		// When
		String result = this.booking.getDescription();

		// Then
		assertEquals("Reserva para la clase de informática", result);
	}
	
	@Test
	public void testSetId() {
		// Given

		// When
		this.booking.setId(2);

		// Then
		assertEquals(2, this.booking.getId());
	}
	
	@Test
	public void testSetRoomId() {
		// Given

		// When
		this.booking.setRoomId(2);

		// Then
		assertEquals(2, this.booking.getRoomId());
	}
	
	@Test
	public void testSetUserId() {
		// Given

		// When
		this.booking.setUserId(2);

		// Then
		assertEquals(2, this.booking.getUserId());
	}
	
	@Test
	public void testSetDate() {
		// Given

		// When
		this.booking.setDate("17/06/2024");

		// Then
		assertEquals("17/06/2024", this.booking.getDate());
	}
	
	@Test
	public void testSetDescription() {
		// Given

		// When
		this.booking.setDescription("Reserva para la clase de matemáticas");

		// Then
		assertEquals("Reserva para la clase de matemáticas", this.booking.getDescription());
	}
	
}
