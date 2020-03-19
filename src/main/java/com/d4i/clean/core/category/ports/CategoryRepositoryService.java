package com.d4i.clean.core.category.ports;

import java.util.Collection;

import com.d4i.clean.core.category.Category;
import com.d4i.clean.infraestructure.shared.exceptions.NetflixException;

public interface CategoryRepositoryService {

	public Collection<Category> getAllCategories();
	
	public void saveCategory(Category category) throws NetflixException;
}
