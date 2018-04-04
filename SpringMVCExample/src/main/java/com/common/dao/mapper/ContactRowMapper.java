package com.common.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.common.data.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	public Contact mapRow(ResultSet rs, int index) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getInt("ID"));
		contact.setFirstName(rs.getString("FIRSTNAME"));
		contact.setLastName(rs.getString("LASTNAME"));
		contact.setBirthDate(rs.getDate("BIRTHDATE"));
		return contact;
	}

}
