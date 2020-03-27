package com.d4i.sample.movie.category.usecase;

import java.util.Collection;

import com.d4i.sample.movie.category.Category;

public interface GetAllCategoriesUseCase {

	public Collection<Category> execute();
	
}
