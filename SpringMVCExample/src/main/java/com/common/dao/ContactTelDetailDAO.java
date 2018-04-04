package com.common.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.common.dao.interfaces.AbstractDAO;
import com.common.dao.mapper.ContactRowMapper;
import com.common.dao.mapper.ContactTelDetailRowMapper;
import com.common.data.Contact;
import com.common.data.ContactTelDetail;

@Repository
public class ContactTelDetailDAO implements AbstractDAO<ContactTelDetail> {

	private JdbcTemplate jdbcTemplate;
	private ContactTelDetailRowMapper contactTelDetailRowMapper;

	@Autowired
	public ContactTelDetailDAO(DriverManagerDataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		contactTelDetailRowMapper = new ContactTelDetailRowMapper();
	}

	public ContactTelDetailDAO() {

	}

	public ContactTelDetail getById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM CONTACT_TEL_DETAIL WHERE ID=?",
				contactTelDetailRowMapper, id);
	}

	public List<ContactTelDetail> getByContactId(int contactId) {
		return jdbcTemplate.query("SELECT * FROM CONTACT_TEL_DETAIL WHERE CONTACT_ID=?",
				contactTelDetailRowMapper, contactId);
	}

	public List<ContactTelDetail> getAll() {
		return jdbcTemplate.query("SELECT * FROM CONTACT_TEL_DETAIL", contactTelDetailRowMapper);
	}

	public int insert(ContactTelDetail obj) {
		String sql = "INSERT INTO CONTACT_TEL_DETAIL (CONTACT_ID, TEL_TYPE, TEL_NUMBER) VALUES ("
				+ "?,?,?)";
		return jdbcTemplate.update(sql, getPreperedStatementSetter(obj));

	}
	
	private PreparedStatementSetter getPreperedStatementSetter(final ContactTelDetail obj){
		return new PreparedStatementSetter(){
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 0;
				ps.setInt(++i, obj.getContactId());
				ps.setString(++i, obj.getTelType().name());
				ps.setString(++i, obj.getTelNumber());
			}		
		};
	}

}
