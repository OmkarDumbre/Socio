package com.sociotweet.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sociotweet.dao.AuthDao;
import com.sociotweet.model.Response;
import com.sociotweet.model.User;

@Repository
public class AuthDaoImpl implements AuthDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public Response register(User user) {
		jdbcTemplate.update("Insert into user values(?,?,?,?,?,?)",user.getEmailId(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getWardNo(),user.getUserRole());
		Response response = new Response();
		response.setResult("success");
		return response;
	}

	@Override
	public User login(User user) {
		 String sql = "SELECT * FROM user WHERE email_id = ? AND password=? ";
		 return user;
		
	}

}
