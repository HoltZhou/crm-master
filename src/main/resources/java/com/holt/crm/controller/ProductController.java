package com.holt.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.holt.crm.pojo.Category;
import com.holt.crm.pojo.CategoryExample;
import com.holt.crm.pojo.Product;
import com.holt.crm.pojo.ProductExample;
import com.holt.crm.pojo.ProductExample.Criteria;
import com.holt.crm.service.ICategoryService;
import com.holt.crm.service.IProductService;
import com.holt.crm.utils.Operation;


/**
 * 
 * @author zh
 *
 */
@Operation(name="产品管理")
@Controller
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;

	private Logger logger = LoggerFactory.getLogger(ProductController.class); 
	
	/**
	 * 分页查找产品
	 * 
	 * @author zh
	 * @return Map<String,Object>
	 * @version 1.0
	 * @exception Nothing
	 */
	@Operation(name="查看所有产品")
	@RequestMapping("/findProduct")
	@ResponseBody
	public Map<String, Object> findProduct(Integer page, Integer limit, Product product) {

		Map<String, Object> map = new HashMap<String, Object>(16);

		ProductExample productExample = new ProductExample();
		Criteria criteria = productExample.createCriteria();

		if (page == null || page <= 0) {
			page = 1;
		}
		if (limit == null || limit <= 0) {
			limit = 10;
		}

		// where条件
		if (product.getId() != null) {
			criteria.andIdEqualTo(product.getId());
		}
		if (product.getName() != null) {
			criteria.andNameLike("%" + product.getName() + "%");
		}
		if (product.getLocation()!=null) {
			criteria.andLocationLike("%"+product.getLocation()+"%");
		}
		if (product.getCategoryId()!=null) {
			criteria.andCategoryIdEqualTo(product.getCategoryId());
		}

		Long count = productService.countByProductExample(productExample);

		//第几条开始分页
		Long offset = new Long((page - 1) * limit);
		//每页多少条
		productExample.setLimit(limit);
		productExample.setOffset(offset);

		List<Product> list = productService.selectByProductExample(productExample);

		logger.info(list.toString());

		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "success");
		map.put("count", count);
		return map;
	}
	
	
	@Operation(name="查看产品的所有分类")
	@RequestMapping("/findCategory")
	@ResponseBody
	public Map<String, Object> findCategory(Category category){
		Map<String,Object> map = new HashMap<String,Object>(16);
		
		CategoryExample categoryExample = new CategoryExample();
		com.holt.crm.pojo.CategoryExample.Criteria criteria = categoryExample.createCriteria();
		
		if(category.getId()!=null){
			criteria.andIdEqualTo(category.getId());
		}
		if(category.getName()!=null){
			criteria.andNameLike("%"+category.getName()+"%");
		}
		
		List<Category> list = categoryService.selectByCategoryExample(categoryExample);
		map.put("categorys", list);
		return map;
	}
	
	

}
