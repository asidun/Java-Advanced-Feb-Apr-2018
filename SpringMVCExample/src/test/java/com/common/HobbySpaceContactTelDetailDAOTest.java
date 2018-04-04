package com.common;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.dao.ContactTelDetailDAO;
import com.common.dao.interfaces.AbstractDAO;
import com.common.data.Contact;
import com.common.data.ContactTelDetail;
import com.common.data.TelType;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/resources/Spring-Module.xml") 
public class HobbySpaceContactTelDetailDAOTest {
	
	@Autowired
	ContactTelDetailDAO contactTelDetailDAO;
	
	@Test
	public void testGetById(){
		Assert.assertEquals("321", contactTelDetailDAO.getByContactId(2).get(0).getTelNumber());
	}
	
	@Test
	public void testGetAll(){
		Assert.assertEquals(3, contactTelDetailDAO.getAll().size());
	}
	
	@Test
	public void testInsert(){
		ContactTelDetail contactTelDetail = new ContactTelDetail();
		contactTelDetail.setContactId(3);
		contactTelDetail.setTelNumber("444");
		contactTelDetail.setTelType(TelType.HOME);
		contactTelDetailDAO.insert(contactTelDetail);
		Assert.assertEquals("444", contactTelDetailDAO.getByContactId(3).get(0).getTelNumber());
	}

}
