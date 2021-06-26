package logic.entity;

public class Sponsor {
	private String username;
	private String password;
	private String activity;
	private String capacity;
	private String description;
	
	public Sponsor(String username, String password, String activity, String capacity, String description) {
		super();
		this.username = username;
		this.password = password;
		this.activity = activity;
		this.capacity = capacity;
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
