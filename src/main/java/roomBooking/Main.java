package roomBooking;
import java.util.Scanner;

public class Main {
	private static boolean flag = true;
	private static Scanner scanner = new Scanner(System.in);
	private static UserRepository userRepository = new UserRepository();
	
	public static void main(String[] args) {
		while (flag) {
		    // Show initial menu
			showInitialMenu();
			int option;
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				option = 0;
			}
			System.out.println("");
			
			// Handle option
			switch (option) {
			case 1:
				showUserMenu();
				int userOption;
				try {
					userOption = scanner.nextInt();
				} catch (Exception e) {
					userOption = 0;
				}
				handleUserOption(userOption);
				break;
			case 2:
				System.out.println("Administrar salas");
				break;
			case 3:
				System.out.println("Administrar reservas");
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
	
	public static void handleUserOption(int option) {
		switch (option) {
		case 1:
			System.out.println("Crear usuario");
			System.out.println("Ingresa el nombre del usuario:");
			String name = scanner.next();
			System.out.println("Ingresa el departamento del usuario:");
			String department = scanner.next();
			System.out.println("Ingresa la descripción del usuario:");
			String description = scanner.next();
			
			User user = new User(name, department, description);
			userRepository.createUser(user);
			
			System.out.println(user.toString());
			System.out.println("Usuario creado");
			System.out.println("");
			
			break;
		case 2:
			System.out.println("Usuarios");
			for (User u : userRepository.getUsers().values()) {
				System.out.println(u.toString());
			}
			System.out.println("");
			break;
		case 3:
			System.out.println("Actualizar usuario");
			System.out.println("Ingresa el id del usuario a actualizar:");
			int id = scanner.nextInt();
			System.out.println("Ingresa el nombre del usuario:");
			name = scanner.next();
			System.out.println("Ingresa el departamento del usuario:");
			department = scanner.next();
			System.out.println("Ingresa la descripción del usuario:");
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
		case 4:
			System.out.println("Eliminar usuario");
			System.out.println("Ingresa el id del usuario a eliminar:");
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
}
