package test;

import static org.junit.Assert.*;
import logic.bean.ArtistBean;
import logic.applicationController.LoginController;
import org.junit.Test;

public class  Test12 {

	@Test
   public	void test() throws Exception {
			
		LoginController loginController = new LoginController();
 ArtistBean check = loginController.artistLogin("meo","password");
  assertEquals("mimo",check. getTalent());

	}

}









