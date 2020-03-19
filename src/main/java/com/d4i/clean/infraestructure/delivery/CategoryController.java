package com.d4i.clean.infraestructure.delivery;

import java.util.Collection;

import com.d4i.clean.infraestructure.delivery.responses.NetflixResponse;
import com.d4i.clean.infraestructure.delivery.rest.CategoryRest;
import com.d4i.clean.infraestructure.shared.exceptions.NetflixException;

public interface CategoryController {

	NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<Boolean> createCategory(CategoryRest category) throws NetflixException;

}
