package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService
{
	@Inject
	private INewDao newDao;

	@Override
	public List<NewModel> findByCategoryId(Long categoryID) {
		return newDao.findByCategoryId(categoryID);
	}

	@Override
	public NewModel save(NewModel newModel) {
		Long newId = newDao.save(newModel);
		System.out.println(newId);
		
		return null;
	}
	
}
