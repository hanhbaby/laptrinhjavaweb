package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.GenericDao;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDao<T> implements GenericDao<T>{
	public Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.driver");
			String url = "jdbc:mysql://localhost:3306/newsqlservlet02102020";
			String user = "root";
			String password = "1234";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parameter
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				results.add(rowMapper.mapRow(resultSet));
			}
			return 	results;
		}catch(SQLException e)
		{
			return null;
		}finally
		{
			try {
				if(connection != null)
				{
					connection.close();
				}
				if(statement != null)
				{
					statement = null;
				}
				if(resultSet != null)
				{
					resultSet = null;
				}
				
			} catch (SQLException e2) {
				return null;
			}
			
		}
		
	}

}
