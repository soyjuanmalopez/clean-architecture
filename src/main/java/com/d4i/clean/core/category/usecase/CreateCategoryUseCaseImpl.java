package com.d4i.clean.core.category.usecase;

import com.d4i.clean.core.category.Category;
import com.d4i.clean.core.category.exception.CategoryAlreadyExistException;
import com.d4i.clean.core.category.ports.CategoryRepositoryService;
import com.d4i.clean.infraestructure.shared.exceptions.NetflixException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

	private final CategoryRepositoryService categoryRepositoryService;

	@Override
	public void execute(Category category) throws NetflixException {

		if(categoryRepositoryService.doesCategoryNameExists(category.getName())) {
			throw new CategoryAlreadyExistException("Not unique category");
		};

		categoryRepositoryService.saveCategory(category);
	}

}
