package com.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.data.Contact;
import com.common.data.TelephoneBook;
import com.common.service.TelBookService;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/resources/Spring-Module.xml") 
public class HobbySpaceServiceTests {

	@Autowired
	TelBookService telBookService;

	@Test
	public void testGetContactById(){
		Contact contact = telBookService.getContactById(1);
		Assert.assertEquals("241", contact.getTelDetails().get(1).getTelNumber());
	}
	
	@Test
	public void testAddContact(){
		Contact contact2 = new Contact();
		contact2.setFirstName("user2");
		contact2.setLastName("user2");
		telBookService.addContact(contact2);
		List<Contact> contactsList = telBookService.getContactsList();
		Assert.assertEquals(contactsList.get(contactsList.size() - 1).getFirstName(), "user2");
	}
//	
//	@Test
//	public void testDeleteContact(){
//		telBookService.delContact(0);
//		System.out.println(telBookService.getContactsList().get(0).getFirstName());
//		Assert.assertEquals(telBookService.getContactsList().get(0).getFirstName(), "user2");
//	}
	
//	@Test
//	public void testSearchByFirstName(){
//		String etalonName = "user2";
//		Contact contact = telBookService.SearchByFirstName(etalonName);
//		Assert.assertEquals(etalonName, contact.getFirstName());
//	}
	
}
