package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDao implements ICategoryDao {
	
	public Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.driver");
			String url = "jdbc:mysql://localhost:3306/newsqlservlet02102020";
			String user = "root";
			String password = "1234";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e)//| SQLException e
		{
			return null;
		}
		catch (SQLException e)
		{
			return null;
		}

	}
	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<>();
		String sql = "SELECT * FROM category";
		//open connection
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null)
		{
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					CategoryModel  category = new CategoryModel();
					category.setId(resultSet.getLong("id"));
					category.setCode(resultSet.getString("code"));
					category.setName(resultSet.getString("name"));
					results.add(category);
					
				}
				
				return results;
				
			} catch (SQLException e) {
				return null;
			}
			finally
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
		
		return null;
	}
	
}
