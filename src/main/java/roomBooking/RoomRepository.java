package roomBooking;
import java.util.HashMap;

public class RoomRepository {
	private HashMap<Integer, Room> rooms;
	private int idCounter = 1;
	
	public RoomRepository() {
		this.rooms = new HashMap<Integer, Room>();
	}

	public void setRooms(HashMap<Integer, Room> rooms) {
		this.rooms = rooms;
	}

	public HashMap<Integer, Room> getRooms() {
		return this.rooms;
	}
	
	public Room getRoomById(int id) {
		Room room = this.rooms.get(id);
		
		return room;
	}
	
	public Room createRoom(Room room) {
        room.setId(this.idCounter++);
        
		this.rooms.put(room.getId(), room);
		
		return room;
	}
	
	public Room deleteRoom(int id) {
		Room deletedRoom = this.rooms.remove(id);
		
		return deletedRoom;
	}
	
	public Room updateRoom(Room room) {
		if (!this.rooms.containsKey(room.getId())) {
			return null;
		}
		
		this.rooms.put(room.getId(), room);
		
		return room;
	}
}
