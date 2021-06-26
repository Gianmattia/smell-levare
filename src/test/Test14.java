package test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

import logic.applicationController.RSSApplicationController;
import   logic.bean.RequestedShowBean;

public class Test14 {

	@Test
	public void chechdescriptionshow() {
		RequestedShowBean check = new RequestedShowBean();
    check.setDescription("Un bravo cantante");
    assertEquals("Un bravo cantante",check.getDescription());

		
		
		
		
	}

}


























