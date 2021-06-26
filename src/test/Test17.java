package test;
import logic.dao.SponsoredShowDao;
import logic.entity.Artist;
import logic.entity.SponsoredShow;

import static org.junit.Assert.*;

import org.junit.Test;


import static org.junit.Assert.*;

import org.junit.Test;

public class Test17 {

	@Test
	public void test() {

		SponsoredShowDao spondoreddao = new  SponsoredShowDao();
		SponsoredShow check =  spondoreddao.getSponsoredShow("prova");
	    assertEquals("no",check.getPartner());


	}

}
