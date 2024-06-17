package roomBooking;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
	private static boolean flag = true;
	private static Scanner scanner = new Scanner(System.in);
	private static UserRepository userRepository = new UserRepository();
	private static RoomRepository roomRepository = new RoomRepository();
	private static BookingRepository bookingRepository = new BookingRepository();
	
	public static void main(String[] args) {
		while (flag) {
		    // Show initial menu
			showInitialMenu();
			int option;
			
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				showInitialMenu();
			}
			option = scanner.nextInt();
			
			System.out.println("");
			
			// Handle option
			switch (option) {
			
			// User menu
			case 1:
				showUserMenu();
				int userOption;
				while (scanner.hasNextInt() == false) {
					scanner.next();
					System.out.println("Opción inválida");
					showUserMenu();
				}
				userOption = scanner.nextInt();
				handleUserOption(userOption);
				break;
				
			// Room menu
			case 2:
				System.out.println("Administrar salas");
				showRoomMenu();
				int roomOption;
				while (scanner.hasNextInt() == false) {
					scanner.next();
					System.out.println("Opción inválida");
					showRoomMenu();
				}
				roomOption = scanner.nextInt();
				handleRoomOption(roomOption);
				break;
				
			// Booking menu
			case 3:
				System.out.println("Administrar reservas");
				showBookingMenu();
				int bookingOption;
				while (scanner.hasNextInt() == false) {
					scanner.next();
					System.out.println("Opción inválida");
					showBookingMenu();
				}
				bookingOption = scanner.nextInt();
				handleBookingOption(bookingOption);
				break;
				
			case 4:
				System.out.println("Salir");
				flag = false;
				System.out.println("Sistema cerrado");
				break;
				
			default:
				System.out.println("Opción inválida");
				break;
			}
			
		}
		scanner.close();
		
	}
	
	public static void showInitialMenu() {
		System.out.println("Bienvenido al sistema de reservas de salas!");
		System.out.println("Porfavor selecciona una opción:");
		System.out.println("1. Administrar usuarios");
		System.out.println("2. Administrar salas");
		System.out.println("3. Administrar reservas");
		System.out.println("4. Salir");
	}
	
	public static void showUserMenu() {
		System.out.println("Menú de usuarios");
		System.out.println("Porfavor selecciona una opción:");
		System.out.println("1. Crear usuario");
		System.out.println("2. Ver usuarios");
		System.out.println("3. Actualizar usuario");
		System.out.println("4. Eliminar usuario");
		System.out.println("5. Regresar");
	}
	
	public static void showRoomMenu() {
		System.out.println("Menú de salas");
		System.out.println("Porfavor selecciona una opción:");
		System.out.println("1. Crear sala");
		System.out.println("2. Ver salas");
		System.out.println("3. Actualizar sala");
		System.out.println("4. Eliminar sala");
		System.out.println("5. Regresar");
	}
	
	public static void showBookingMenu() {
		System.out.println("Menú de reservas");
		System.out.println("Porfavor selecciona una opción:");
		System.out.println("1. Crear reserva");
		System.out.println("2. Ver reservas");
		System.out.println("3. Actualizar reserva");
		System.out.println("4. Eliminar reserva");
		System.out.println("5. Regresar");
	}
	
	public static void handleUserOption(int option) {
		switch (option) {
		
		// Create user
		case 1:
			System.out.println("Crear usuario");
			System.out.println("Ingresa el nombre del usuario:");
			scanner.nextLine();
			String name = scanner.nextLine();
			
			System.out.println("Ingresa el departamento del usuario:");
			
			String department = scanner.nextLine();
			
			System.out.println("Ingresa la descripción del usuario:");

			String description = scanner.nextLine();
			
			User user = new User(name, department, description);
			userRepository.createUser(user);
			
			System.out.println(user.toString());
			System.out.println("Usuario creado");
			System.out.println("");
			
			break;
			
		// View users
		case 2:
			System.out.println("Usuarios");
			for (User u : userRepository.getUsers().values()) {
				System.out.println(u.toString());
			}
			System.out.println("");
			break;
			
		// Update user
		case 3:
			System.out.println("Actualizar usuario");
			System.out.println("Ingresa el id del usuario a actualizar:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el id del usuario a actualizar:");
			}
			int id = scanner.nextInt();
			
			System.out.println("Ingresa el nombre actualizado del usuario:");
			scanner.nextLine();
			name = scanner.nextLine();
			
			System.out.println("Ingresa el departamento actualizado del usuario:");
			department = scanner.nextLine();
			
			System.out.println("Ingresa la descripción actualizada del usuario:");
			description = scanner.next();
			
			user = new User(id, name, department, description);
			User updatedUser = userRepository.updateUser(user);
			
			if (updatedUser != null) {
				System.out.println(updatedUser.toString());
				System.out.println("Usuario actualizado");
			} else {
				System.out.println("Usuario no encontrado");
			}
			System.out.println("");
			
			break;
			
		// Delete user
		case 4:
			System.out.println("Eliminar usuario");
			System.out.println("Ingresa el id del usuario a eliminar:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el id del usuario a eliminar:");
			}
			id = scanner.nextInt();
			
			User deletedUser = userRepository.deleteUser(id);
			
			if (deletedUser != null) {
				System.out.println(deletedUser.toString());
				System.out.println("Usuario eliminado");
			} else {
				System.out.println("Usuario no encontrado");
			}
			System.out.println("");
			break;
		case 5:
			System.out.println("Regresar");
			break;
		default:
			System.out.println("Opción inválida");
			break;
		}
	}
	
	public static void handleRoomOption(int option) {
		switch (option) {
		
		// Create room
        case 1:
            System.out.println("Crear sala");
			System.out.println("Ingresa el nombre de la sala:");
			scanner.nextLine();
			String name = scanner.nextLine();
			
			System.out.println("Ingresa la ubicación de la sala:");
			String location = scanner.nextLine();
			
			Room room = new Room(name, location);
			roomRepository.createRoom(room);
			
			System.out.println(room.toString());
			System.out.println("Sala creada");
			System.out.println("");
            break;
        
        // View rooms
        case 2:
            System.out.println("Salas");
            for (Room r : roomRepository.getRooms().values()) {
            	System.out.println(r.toString());                
            }
            System.out.println("");
            break;
            
        // Update room
        case 3:
            System.out.println("Actualizar sala");
			System.out.println("Ingresa el id de la sala a actualizar:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el id de la sala a actualizar:");
			}
			int id = scanner.nextInt();
			
			System.out.println("Ingresa el nombre actualizado de la sala:");
			scanner.nextLine();
			name = scanner.nextLine();
			
			System.out.println("Ingresa la ubicación actualizada de la sala:");
			location = scanner.nextLine();
			
			room = new Room(id, name, location);
			Room updatedRoom = roomRepository.updateRoom(room);
			
			if (updatedRoom != null) {
				System.out.println(updatedRoom.toString());
				System.out.println("Sala actualizada");
			} else {
				System.out.println("Sala no encontrada");
			}
			System.out.println("");
            break;
            
        // Delete room
        case 4:
        	System.out.println("Eliminar sala");
			System.out.println("Ingresa el id de la sala a eliminar:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el id de la sala a eliminar:");
			}
			id = scanner.nextInt();
			
			Room deletedRoom = roomRepository.deleteRoom(id);
			
			if (deletedRoom != null) {
				System.out.println(deletedRoom.toString());
				System.out.println("Sala eliminada");
			} else {
				System.out.println("Sala no encontrada");
			}
			System.out.println("");
			break;
        case 5:
            System.out.println("Regresar");
            break;
        default:
            System.out.println("Opción inválida");
            break;
        }
    }
	
	public static void handleBookingOption(int option) {
		switch (option) {
		// Create booking
        case 1:
            System.out.println("Crear reserva");
			System.out.println("Ingresa el ID del usuario:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el ID del usuario:");
			}
			int userId = scanner.nextInt();
			
			System.out.println("Ingresa el ID de la sala:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el ID de la sala:");
			}
			int roomId = scanner.nextInt();
			
			System.out.println("Ingresa la fecha (dd-MM-yyyy):");
			while (scanner.hasNext("[0-9]{2}-[0-9]{2}-[0-9]{4}") == false) {
                scanner.next();
                System.out.println("Opción inválida");
                System.out.println("Ingresa la fecha (dd-MM-yyyy):");
            }
			String date = scanner.next();
			
			System.out.println("Ingresa el detalle de la reserva:");
			scanner.nextLine();
			String description = scanner.nextLine();
			
			boolean isAvailable = true;
			
			// Verify if user exists
			User user = userRepository.getUserById(userId);
			if (user == null) {
                System.out.println("Usuario no encontrado");
                System.out.println("");
                isAvailable = false;
            }
			
			// Verify if room exists
		    Room room = roomRepository.getRoomById(roomId);
		    if (room == null) {
                System.out.println("Sala no encontrada");
                System.out.println("");
                isAvailable = false;
            }
		    
		    // Verify if exist booking for the same room and date
		    HashMap<Integer, Booking> bookings = bookingRepository.getBookings();
		    
		    for (Booking b : bookings.values()) {
                if (b.getRoomId() == roomId && b.getDate().equals(date)) {
                    System.out.println("La sala ya está reservada para esta fecha");
                    System.out.println("");
                    isAvailable = false;
                    break;
                }
            }
		    
		    if (!isAvailable) {
		    	break;
		    }
		    
		    // Create booking
			Booking booking = new Booking(userId, roomId, date, description);
			booking = bookingRepository.createBooking(booking);
			
			System.out.println(booking.toString());
			System.out.println("Reserva creada");
			System.out.println("");
            break;
            
        // View bookings
        case 2:
            System.out.println("Reservas");
            for (Booking b : bookingRepository.getBookings().values()) {
            	System.out.println(b.toString());                
            }
            System.out.println("");
            break;
        
        // Update booking
        case 3:
        	System.out.println("Actualizar reserva");
        	
        	System.out.println("Ingresa el ID de la reserva:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el ID de la reserva:");
			}
			int id = scanner.nextInt();
			
			System.out.println("Ingresa el ID actualizada del usuario:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el ID del usuario:");
			}
			userId = scanner.nextInt();
			
			System.out.println("Ingresa el ID actualizada de la sala:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el ID de la sala:");
			}
			roomId = scanner.nextInt();
			
			
			System.out.println("Ingresa la fecha actualizada (dd-MM-yyyy):");
			while (scanner.hasNext("[0-9]{2}-[0-9]{2}-[0-9]{4}") == false) {
                scanner.next();
                System.out.println("Opción inválida");
                System.out.println("Ingresa la fecha (dd-MM-yyyy):");
            }
			date = scanner.next();
			
			System.out.println("Ingresa el detalle actualizado de la reserva:");
			scanner.nextLine();
			description = scanner.nextLine();
			
			isAvailable = true;
			
			// Verify if user exists
			user = userRepository.getUserById(userId);
			if (user == null) {
                System.out.println("Usuario no encontrado");
                System.out.println("");
                isAvailable = false;
            }
			
			// Verify if room exists
		    room = roomRepository.getRoomById(roomId);
		    if (room == null) {
                System.out.println("Sala no encontrada");
                System.out.println("");
                isAvailable = false;
            }
		    
		    // Verify if exist booking for the same room and date
		    bookings = bookingRepository.getBookings();
		    
		    for (Booking b : bookings.values()) {
                if (b.getRoomId() == roomId && b.getDate().equals(date)) {
                    System.out.println("La sala ya está reservada para esta fecha");
                    System.out.println("");
                    isAvailable = false;
                    break;
                }
            }
		    
		    if (!isAvailable) {
		    	break;
		    }
		    
		    // update booking
			booking = new Booking(id, userId, roomId, date, description);
			booking = bookingRepository.updateBooking(booking);
			
			if (booking != null) {
				System.out.println(booking.toString());
				System.out.println("Reserva actualizada");
			} else {
				System.out.println("Reserva no encontrada");
			}
			System.out.println("");
            break;
        // Delete booking
        case 4:
            System.out.println("Eliminar reserva");
            System.out.println("Ingresa el ID de la reserva a eliminar:");
			while (scanner.hasNextInt() == false) {
				scanner.next();
				System.out.println("Opción inválida");
				System.out.println("Ingresa el ID de la reserva a eliminar:");
			}
			id = scanner.nextInt();
			
			Booking deletedBooking = bookingRepository.deleteBooking(id);
			
			if (deletedBooking != null) {
				System.out.println(deletedBooking.toString());
				System.out.println("Reserva eliminada");
			} else {
				System.out.println("Reserva no encontrada");
			}
			System.out.println("");
            break;
        case 5:
            System.out.println("Regresar");
            break;
        default:
            System.out.println("Opción inválida");
            break;
            }
	}
	
}
