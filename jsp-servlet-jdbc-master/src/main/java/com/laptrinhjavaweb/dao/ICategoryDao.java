package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDao {
	List<CategoryModel> findAll();// lay tat ca cac the loai
}
