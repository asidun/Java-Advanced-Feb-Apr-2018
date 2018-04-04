package com.common.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.common.dao.interfaces.AbstractDAO;
import com.common.dao.mapper.ContactRowMapper;
import com.common.data.Contact;
import com.common.data.ContactTelDetail;

@Repository
public class ContactDAO implements AbstractDAO<Contact> {
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Contact> contactRowMapper;

	@Autowired
	public ContactDAO(DriverManagerDataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		contactRowMapper = new ContactRowMapper();
	}
	
	public ContactDAO(){
		
	}

	public Contact getById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM CONTACT WHERE ID=?", contactRowMapper, id);
	}

	public List<Contact> getAll() {
		return jdbcTemplate.query("SELECT * FROM CONTACT", contactRowMapper);
	}

	public int insert(Contact obj) {
		String sql = "INSERT INTO CONTACT (FIRSTNAME, LASTNAME) VALUES (?,?)";
		return jdbcTemplate.update(sql, getPreperedStatementSetter(obj));
		
	}
	
	private PreparedStatementSetter getPreperedStatementSetter(final Contact obj){
		return new PreparedStatementSetter(){
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 0;
				ps.setString(++i, obj.getFirstName());
				ps.setString(++i, obj.getLastName());
			}		
		};
	}

}
