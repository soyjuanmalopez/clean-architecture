package com.d4i.clean.core.category.usecase;

import com.d4i.clean.core.category.Category;
import com.d4i.clean.core.category.ports.CategoryRepositoryService;
import com.d4i.clean.infraestructure.shared.constants.ExceptionConstants;
import com.d4i.clean.infraestructure.shared.exceptions.BadRequestException;
import com.d4i.clean.infraestructure.shared.exceptions.NetflixException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

	private final CategoryRepositoryService categoryRepositoryService;

	@Override
	public void execute(Category category) throws NetflixException {

		if (category.getName().length() > 25)
			throw new BadRequestException(ExceptionConstants.BAD_REQUEST_DEFAULT_MESSAGE);
		
		categoryRepositoryService.saveCategory(category);
	}

}
