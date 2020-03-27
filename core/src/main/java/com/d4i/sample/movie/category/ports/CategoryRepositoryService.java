package com.d4i.sample.movie.category.ports;

import java.util.Collection;

import com.d4i.sample.movie.category.Category;

public interface CategoryRepositoryService {

	public Collection<Category> getAllCategories();
	
	public void saveCategory(Category category) ;

	public Boolean doesCategoryNameExists(String name);
}
