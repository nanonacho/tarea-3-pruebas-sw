package roomBooking;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomRepositoryTest {
	private RoomRepository repository;
	private Room room;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = new RoomRepository();
		room = new Room("P-101", "Edificio P");
	}
	
	@Test
	public void testSetRooms() {
		// Given
		HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
		this.room.setId(1);
		rooms.put(this.room.getId(), this.room);

		// When
		this.repository.setRooms(rooms);

		// Then
		assertTrue(this.repository.getRooms().get(1).equalValues(rooms.get(1)));
	}
	
	@Test
	public void testGetRooms() {
		// Given
		HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
		this.room.setId(1);
		rooms.put(this.room.getId(), this.room);
		this.repository.setRooms(rooms);

		// When
		HashMap<Integer, Room> result = this.repository.getRooms();

		// Then
		assertTrue(result.get(1).equalValues(rooms.get(1)));
	}
	
	@Test
	public void testGetRoomById() {
		// Given
		HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
		this.room.setId(1);
		rooms.put(this.room.getId(), this.room);
		this.repository.setRooms(rooms);

		// When
		Room result = this.repository.getRoomById(room.getId());

		// Then
		assertTrue(result.equalValues(room));
	}
	
	@Test
	public void testGetRoomByIdNotFound() {
		// Given

		// When
		Room result = this.repository.getRoomById(1);
		
		// Then
		assertNull(result);
	}
	
	@Test
	public void testCreateRoom() {
		// Given
		
		// When
		Room createdRoom = this.repository.createRoom(room);
		
		// Then
		assertTrue(room.equalValues(createdRoom));
	}
	
	@Test
	public void testUpdateRoom() {
		// Given
		Room createdRoom = this.repository.createRoom(room);
		
		// When
		Room roomToUpdate = new Room(1,"P-102", "Edificio P");
		Room updatedRoom = this.repository.updateRoom(roomToUpdate);
		
		// Then
		assertTrue(!createdRoom.equalValues(updatedRoom));
		assertTrue(roomToUpdate.equalValues(updatedRoom));
	}
	
	@Test
	public void testUpdateRoomNotFound() {
		// Given
		room.setId(1);

		// When
		Room updatedRoom = this.repository.updateRoom(room);
		
		// Then
		assertNull(updatedRoom);
	}
	
	@Test
	public void testDeleteRoom() {
		// Given
		Room createdRoom = this.repository.createRoom(room);
		
		// When
		Room deletedRoom = this.repository.deleteRoom(createdRoom.getId());
		
		// Then
		assertNull(this.repository.getRooms().get(createdRoom.getId()));
		assertTrue(createdRoom.equalValues(deletedRoom));
	}
	
	@Test
	public void testDeleteRoomNotFound() {
		// Given
		room.setId(1);

		// When
		Room deletedRoom = this.repository.deleteRoom(1);
		
		// Then
		assertNull(deletedRoom);
	}

}
