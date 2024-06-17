package roomBooking;
import java.util.HashMap;


public class BookingRepository {
	private HashMap<Integer, Booking> bookings;
	private int idCounter = 1;

	public BookingRepository() {
		this.bookings = new HashMap<Integer, Booking>();
	}

	public void setBookings(HashMap<Integer, Booking> bookings) {
		this.bookings = bookings;
	}

	public HashMap<Integer, Booking> getBookings() {
		return this.bookings;
	}

	public Booking getBookingById(int id) {
		Booking booking = this.bookings.get(id);

		return booking;
	}

	public Booking createBooking(Booking booking) {
		booking.setId(this.idCounter++);

		this.bookings.put(booking.getId(), booking);

		return booking;
	}

	public Booking deleteBooking(int id) {
		Booking deletedBooking = this.bookings.remove(id);

		return deletedBooking;
	}

	public Booking updateBooking(Booking booking) {
		if (!this.bookings.containsKey(booking.getId())) {
			return null;
		}
		
		this.bookings.put(booking.getId(), booking);
		
		return booking;
	}
}
