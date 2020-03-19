package com.d4i.clean.infraestructure.delivery.converters;

import com.d4i.clean.core.category.Category;
import com.d4i.clean.infraestructure.delivery.rest.CategoryRest;
import com.d4i.clean.infraestructure.shared.RestConverter;

public class CategoryRestConverter implements RestConverter<CategoryRest, Category> {

	@Override
	public Category mapToEntity(final CategoryRest rest) {

		return new Category(null, rest.getName(), rest.getAvailable());
	}

	@Override
	public CategoryRest mapToRest(final Category entity) {
		return new CategoryRest(entity.getName(), entity.getAvailable());
	}

}
