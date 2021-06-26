package logic.bean;

public class RequestedShowBean {
	String host;
	String title;
	String partner;
	String artist;
	String description;
	String approvedArtist;
	String approvedPartner;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApprovedArtist() {
		return approvedArtist;
	}

	public void setApprovedArtist(String approvedArtist) {
		this.approvedArtist = approvedArtist;
	}

	public String getApprovedPartner() {
		return approvedPartner;
	}

	public void setApprovedPartner(String approvedPartner) {
		this.approvedPartner = approvedPartner;
	}
	
}
