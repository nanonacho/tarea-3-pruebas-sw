package roomBooking;

public class User {
	private int id;
	private String name;
	private String department;
	private String description;

	public User(int id, String name, String department, String description) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.description = description;
	}
	
	public User(String name, String department, String description) {
		super();
		this.name = name;
		this.department = department;
		this.description = description;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean equalValues(User user) {
		if (this.id == user.getId() && this.name.equals(user.getName()) && this.department.equals(user.getDepartment())
				&& this.description.equals(user.getDescription())) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String userString = "Usuario [id=" + this.id + ", nombre=" + this.name + ", departamento=" + this.department + ", descripcion=" + this.description + "]";
		return userString;
	}
}
