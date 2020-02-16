package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;

public class NewDao extends AbstractDao<NewModel> implements INewDao
{

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
		
	}

	@Override
	public Long save(NewModel newModel) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		Long id = null;
		try {
			String sql = "INSERT INTO news(title, content, categoryid) VALUES(? ,? , ?)" ;
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, newModel.getTitle());
			statement.setString(2, newModel.getContent());
			statement.setLong(3, newModel.getCategoryId());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next())
			{
				return resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
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
				
			}catch (SQLException e2) {
				return null;
			}
		}
	}
	

}
