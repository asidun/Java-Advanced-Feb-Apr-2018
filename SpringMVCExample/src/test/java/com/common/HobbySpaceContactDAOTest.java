package com.common;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.data.Contact;
import com.common.dao.interfaces.AbstractDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/resources/Spring-Module.xml") 
public class HobbySpaceContactDAOTest {
	
	@Autowired
	AbstractDAO<Contact> contactDAO;
	
	@Test
	public void testGetById(){
		Assert.assertEquals("Bob", contactDAO.getById(1).getFirstName());
	}
	
	@Test
	public void testGetAll(){
		Assert.assertEquals(4, contactDAO.getAll().size());
	}

}
