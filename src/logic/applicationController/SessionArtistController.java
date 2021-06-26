package logic.applicationController;

import logic.dao.ArtistDao;
import logic.entity.Artist;
import logic.utils.SessionArtist;
import logic.utils.SessionUser;

public class SessionArtistController {
	public void sessionArtistSetup() {
		SessionArtist instanceA = SessionArtist.getInstance();
		SessionUser instanceU = SessionUser.getInstance();
		ArtistDao ad = new ArtistDao();
		Artist a = ad.getArtist(instanceU.getUsername()); //uso l'entity, chiedere se è corretto altrimenti tradurre in bean
		instanceA.setUsername(a.getUsername());
		instanceA.setDescription(a.getDescription());
		instanceA.setEmail(a.getEmail());
		instanceA.setPassword(a.getPassword());
		instanceA.setTalent(a.getTalent());
	}
	
	public void update(String username, String email, String talent, String description) {
		SessionArtist instanceA = SessionArtist.getInstance();
		SessionUser instanceU = SessionUser.getInstance();
		instanceU.setUsername(username);
		//finire con implementazione del dao
	}
}
