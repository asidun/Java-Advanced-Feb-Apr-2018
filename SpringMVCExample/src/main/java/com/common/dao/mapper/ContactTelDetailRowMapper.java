package com.common.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.common.data.ContactTelDetail;

public class ContactTelDetailRowMapper implements RowMapper<ContactTelDetail> {

	public ContactTelDetail mapRow(ResultSet rs, int index) throws SQLException {
		ContactTelDetail contactTelDetail = new ContactTelDetail();
		contactTelDetail.setId(rs.getInt("ID"));
		contactTelDetail.setContactId(rs.getInt("CONTACT_ID"));
		contactTelDetail.setTelNumber(rs.getString("TEL_NUMBER"));
		contactTelDetail.setTelType(rs.getString("TEL_TYPE"));
		return contactTelDetail;
	}

}
