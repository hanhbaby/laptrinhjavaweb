package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewDao extends GenericDao<NewModel>
{
	List<NewModel> findByCategoryId(Long categoryId); // load ds bai viet theo the loai
	

}
