package dao.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.impl.CategoryDao;
import com.laptrinhjavaweb.model.CategoryModel;

import dao.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private CategoryDao categoryDao;
	@Override
	public List<CategoryModel> findAll() {
		return null;
	}
	

}
