package roomBooking;

public class Booking {
	private int id;
	private int roomId;
	private int userId;
	private String date;
	private String description;
	
	public Booking(int id, int roomId, int userId, String date, String description) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.userId = userId;
		this.date = date;
		this.description = description;
	}

	public Booking(int roomId, int userId, String date, String description) {
		super();
		this.roomId = roomId;
		this.userId = userId;
		this.date = date;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean equalValues(Booking booking) {
		if (this.id == booking.getId() && this.roomId == booking.getRoomId() && this.userId == booking.getUserId()
				&& this.date.equals(booking.getDate()) && this.description.equals(booking.getDescription())) {
			return true;
		}
		return false;
	}
}
