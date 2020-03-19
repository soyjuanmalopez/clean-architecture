package com.d4i.clean.core.category.usecase;

import com.d4i.clean.core.category.Category;
import com.d4i.clean.infraestructure.shared.exceptions.NetflixException;

public interface CreateCategoryUseCase {

	public void execute(Category category) throws NetflixException;

}
