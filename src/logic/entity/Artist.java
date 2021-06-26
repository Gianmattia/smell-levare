package logic.entity;
//da rifare in base al database
public class Artist {
	private String username;
	private String password;
	private String email;
	private String description;
	private String talent;

	//an artist must give to the system all this informations
	
	public Artist(String username, String password, String email, String description, String talent) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.description = description;
		this.talent = talent;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTalent() {
		return talent;
	}


	public void setTalent(String talent) {
		this.talent = talent;
	}
	
	
}
