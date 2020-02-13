package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao {
	
	
	@Override
	public List<CategoryModel> findAll() 
	{
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}
	
}
