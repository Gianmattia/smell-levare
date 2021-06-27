package test;

import static org.junit.Assert.*;
import logic.bean.ArtistBean;
import logic.exceptions.LoginException;
import logic.applicationController.LoginController;
import org.junit.Test;

public class  Test12 {

	@Test
   public	void test()   {
			
		LoginController loginController = new LoginController();
 ArtistBean check = null;
try {
	check = loginController.artistLogin("meo","password");
} catch (Exception e) {
	e.printStackTrace();
}
  assertEquals("mimo",check. getTalent());

	}

}









