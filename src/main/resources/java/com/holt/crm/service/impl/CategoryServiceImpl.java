package com.holt.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.holt.crm.mapper.CategoryMapper;
import com.holt.crm.pojo.Category;
import com.holt.crm.pojo.CategoryExample;
import com.holt.crm.service.ICategoryService;
/**
 * 
 * @author zh
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public long countByCategoryExample(CategoryExample categoryExample) {
		return categoryMapper.countByExample(categoryExample);
	}

	@Override
	public boolean deleteByCategoryExample(CategoryExample categoryExample) {
		return categoryMapper.deleteByExample(categoryExample) > 0 ? true : false;
	}

	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		return categoryMapper.deleteByPrimaryKey(id) > 0 ? true : false;
	}

	@Override
	public boolean insertCategory(Category category) {
		return categoryMapper.insert(category) > 0 ? true : false;
	}

	@Override
	public boolean insertSelective(Category category) {
		return categoryMapper.insertSelective(category) > 0 ? true : false;
	}

	@Override
	public List<Category> selectByCategoryExample(CategoryExample categoryExample) {
		return categoryMapper.selectByExample(categoryExample);
	}

	@Override
	public Category selectCategoryByPrimaryKey(Integer id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateByCategoryExampleSelective(Category category, CategoryExample categoryExample) {
		return categoryMapper.updateByExampleSelective(category, categoryExample) > 0 ? true : false;
	}

	@Override
	public boolean updateByCategoryExample(Category category, CategoryExample categoryExample) {
		return categoryMapper.updateByExample(category, categoryExample) > 0 ? true : false;
	}

	@Override
	public boolean updateCategoryByPrimaryKeySelective(Category category) {
		return categoryMapper.updateByPrimaryKeySelective(category) > 0 ? true : false;
	}

	@Override
	public boolean updateCategoryByPrimaryKey(Category category) {
		return categoryMapper.updateByPrimaryKey(category) > 0 ? true : false ;
	}

}
