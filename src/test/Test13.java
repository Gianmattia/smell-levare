package test;

import static org.junit.Assert.*;
import logic.bean.ArtistBean;
import logic.bean.GeneralUserBean;
import logic.applicationController.HomepageArtistController;
import logic.bean.EventBean;
import logic.dao.EventDao;
import logic.entity.Event;
import org.junit.Test;

public class test13 {

	@Test
 public	void test() throws Exception {
			
		EventDao eventdao = new EventDao();
  Event    check = eventdao.getEvent("Flavietta");
  assertEquals("Eur",check.getPlace());
	}

}


















