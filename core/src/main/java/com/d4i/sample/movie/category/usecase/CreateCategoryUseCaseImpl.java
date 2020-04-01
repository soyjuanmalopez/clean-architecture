package com.d4i.sample.movie.category.usecase;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.exception.CategoryAlreadyExistException;
import com.d4i.sample.movie.category.ports.CategoryRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

	private final CategoryRepositoryService categoryRepositoryService;

	@Override
	public void execute(Category category) throws CategoryAlreadyExistException   {

		if(categoryRepositoryService.doesCategoryNameExists(category.getName())) {
			throw new CategoryAlreadyExistException();
		};

		categoryRepositoryService.saveCategory(category);
	}

}
