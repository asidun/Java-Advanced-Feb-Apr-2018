package com.common.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.data.Contact;
import com.common.service.TelBookService;

@Controller
@RequestMapping("/addContact")
public class ContactController {

	@Autowired
	TelBookService telBookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showContactForm(Map model){
		Contact contact = new Contact();
		model.put("contact", contact);
		return "add_contact";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveContactForm(@Valid Contact contact, BindingResult result){
		if (result.hasErrors()) {
            return "add_contact";
        }
		telBookService.addContact(contact);
		return "contact_result";
	}
	
}
