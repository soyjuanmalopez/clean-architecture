package com.d4i.sample.movie.category.usecase;

import java.util.Collection;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.ports.CategoryRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllCategoriesUseCaseImpl implements GetAllCategoriesUseCase {

	private final CategoryRepositoryService categoryRepositoryService;

	@Override
	public Collection<Category> execute() {
		return categoryRepositoryService.getAllCategories();
	}

}
