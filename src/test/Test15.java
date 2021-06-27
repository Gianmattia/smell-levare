package test;

import static org.junit.Assert.*;

import org.junit.Test;


import java.util.List;
import logic.applicationController. RequestsArtistController;

import logic.bean.SponsorBean;

import logic.exceptions.DuplicateUsernameException;
import logic.bean.GeneralUserBean;
public class test15 {

	@Test
	public void chechdescriptionshow() throws Exception {
		RequestsArtistController requestsartistcontroller = new RequestsArtistController();
		SponsorBean check = requestsartistcontroller.getSponsor("gigione");
		  assertEquals("100",check.getCapacity());
	
	}

}
































