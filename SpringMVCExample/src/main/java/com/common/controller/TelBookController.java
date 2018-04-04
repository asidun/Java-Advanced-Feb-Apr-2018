package com.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.data.Contact;
import com.common.service.TelBookService;

@Controller
public class TelBookController {
	
	@Autowired
	TelBookService telBookService;
	
	@RequestMapping("/allContacts")	
	public String allContacts(Model model){
		model.addAttribute("contacts", telBookService.getContactsList());
		return "all_contacts";
	}
	
	@RequestMapping("/contact/{id}")
	public String getContact(@PathVariable("id") int id, Model model){
		model.addAttribute("contact", telBookService.getContactById(id));
		return "contact";		
	}
	
	@RequestMapping("/contact/json/{id}")
	public @ResponseBody Contact getContactJson(@PathVariable("id") int id){
		return telBookService.getContactById(id);		
	}

}
