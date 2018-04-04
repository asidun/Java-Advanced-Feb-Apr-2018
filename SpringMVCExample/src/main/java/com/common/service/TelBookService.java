package com.common.service;

import java.util.List;

import javax.crypto.CipherInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.common.dao.ContactDAO;
import com.common.dao.ContactTelDetailDAO;
import com.common.data.Contact;
import com.common.data.TelephoneBook;

@Service
@Transactional
public class TelBookService {
	
	@Autowired
	ContactDAO contactDAO;
	
	@Autowired
	ContactTelDetailDAO contactTelDetailDAO;
	
	public List<Contact> getContactsList() {
		List<Contact> contactsList = contactDAO.getAll();
		for (Contact contact : contactsList) {
			contact.setTelDetails(contactTelDetailDAO.getByContactId(contact.getId()));
		}
		return contactsList;
	}
	
	public Contact getContactById(int id){
		Contact contact = contactDAO.getById(id);
		contact.setTelDetails(contactTelDetailDAO.getByContactId(contact.getId()));
		return contact;
	}

	public void addContact(Contact contact) {
		contactDAO.insert(contact);		
	}
	
}
