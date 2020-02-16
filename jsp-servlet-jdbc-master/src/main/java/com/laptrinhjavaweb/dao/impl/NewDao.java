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
		String sql = "INSERT INTO news(title, content, categoryid) VALUES(? ,? , ?)" ;
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId());
	}

}
