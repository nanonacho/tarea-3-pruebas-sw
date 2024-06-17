package roomBooking;

public class Room {
	private int id;
	private String name;
	private String location;
	
	public Room(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public Room(String name, String location) {
        super();
        this.name = name;
        this.location = location;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean equalValues(Room room) {
		if (this.id == room.getId() && this.name.equals(room.getName()) && this.location.equals(room.getLocation())) {
			return true;
		}
		return false;
	}
	
	
}
