package test;

import static org.junit.Assert.*;
import logic.bean.ArtistBean;
import logic.exceptions.LoginException;
import logic.applicationController.LoginController;
import org.junit.Test;

public class  test12 {

	@Test
   public	void test() throws Throwable  {
			
		LoginController loginController = new LoginController();
 ArtistBean check = loginController.artistLogin("meo","password");
  assertEquals("mimo",check. getTalent());

	}

}









