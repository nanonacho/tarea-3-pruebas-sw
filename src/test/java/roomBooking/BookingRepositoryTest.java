package roomBooking;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;

public class BookingRepositoryTest {
	private BookingRepository repository;
	private Booking booking;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = new BookingRepository();
		booking = new Booking(1, 1, "16/06/2024", "Reserva para la clase de informática");
	}
	
	@Test
	public void testSetBookings() {
		// Given
		HashMap<Integer, Booking> bookings = new HashMap<Integer, Booking>();
		this.booking.setId(1);
		bookings.put(this.booking.getId(), this.booking);

		// When
		this.repository.setBookings(bookings);

		// Then
		assertTrue(this.repository.getBookings().get(1).equalValues(bookings.get(1)));
	}
	
	@Test
	public void testGetBookings() {
		// Given
		HashMap<Integer, Booking> bookings = new HashMap<Integer, Booking>();
		this.booking.setId(1);
		bookings.put(this.booking.getId(), this.booking);
		this.repository.setBookings(bookings);

		// When
		HashMap<Integer, Booking> result = this.repository.getBookings();

		// Then
		assertTrue(result.get(1).equalValues(bookings.get(1)));
	}
	
	@Test
	public void testGetBookingById() {
		// Given
		HashMap<Integer, Booking> bookings = new HashMap<Integer, Booking>();
		this.booking.setId(1);
		bookings.put(this.booking.getId(), this.booking);
		this.repository.setBookings(bookings);

		// When
		Booking result = this.repository.getBookingById(booking.getId());

		// Then
		assertTrue(result.equalValues(booking));
	}
	
	@Test
	public void testGetBookingByIdNotFound() {
        // Given

        // When
        Booking result = this.repository.getBookingById(1);

        // Then
        assertNull(result);
    }
	
	@Test
	public void testCreateBooking() {
		// Given

		// When
		Booking createdBooking = this.repository.createBooking(booking);

		// Then
		assertTrue(createdBooking.equalValues(booking));
	}
	
	@Test
	public void testUpdateBooking() {
		// Given
		Booking createdBooking = this.repository.createBooking(booking);
		
		// When
		Booking bookingToUpdate = new Booking(1, 2, 2, "17/06/2024", "Reserva para la clase de matemáticas");
		Booking updatedBooking = this.repository.updateBooking(bookingToUpdate);
		
		// Then	
		assertTrue(updatedBooking.equalValues(bookingToUpdate));
		assertTrue(!updatedBooking.equalValues(createdBooking));
	}
	
	@Test
	public void testUpdateBookingNotFound() {
		// Given
        this.booking.setId(1);
        
        // When
        Booking updatedBooking = this.repository.updateBooking(this.booking);
        
        // Then
        assertNull(updatedBooking);
    }
	
	@Test
	public void testDeleteBooking() {
		// Given
		Booking createdBooking = this.repository.createBooking(booking);

		// When
		Booking deletedBooking = this.repository.deleteBooking(createdBooking.getId());
		
		// Then
		assertTrue(deletedBooking.equalValues(createdBooking));
		assertNull(this.repository.getBookingById(createdBooking.getId()));
	}
	
	@Test
	public void testDeleteBookingNotFound() {
		// Given
		this.booking.setId(1);

		// When
		Booking deletedBooking = this.repository.deleteBooking(this.booking.getId());

		// Then
		assertNull(deletedBooking);
	}
}
