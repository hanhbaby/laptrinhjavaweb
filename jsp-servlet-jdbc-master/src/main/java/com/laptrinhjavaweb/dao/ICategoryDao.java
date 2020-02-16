package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDao extends GenericDao<CategoryModel> {
	List<CategoryModel> findAll();// lay tat ca cac the loai
}
