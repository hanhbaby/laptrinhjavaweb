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
			System.err.println("A ClassNotFoundException was caught: " + e.getMessage());
            e.printStackTrace();
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
			setParameter(statement,parameters);
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

	private void setParameter(PreparedStatement statement, Object... parameters) 
	{
		try{
			for(int i =0; i< parameters.length; i++)
			{
				Object parameter = parameters[i];
				int index = i +1;
				if(parameter instanceof Long )
				{
					statement.setLong(index,(Long) parameter);
				}
				else if(parameter instanceof String)
				{
					statement.setString(index, (String) parameter);
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
