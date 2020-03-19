package com.d4i.clean.infraestructure.persistence.converters;

import com.d4i.clean.core.category.Category;
import com.d4i.clean.infraestructure.persistence.entities.CategoryEntity;
import com.d4i.clean.infraestructure.shared.RepositoryConverter;

public class CategoryRepositoryConverter implements RepositoryConverter<CategoryEntity, Category> {

	@Override
	public CategoryEntity mapToTable(final Category persistenceObject) {
		return new CategoryEntity(persistenceObject.getId(), persistenceObject.getName(), persistenceObject.getAvailable());
	}

	@Override
	public Category mapToEntity(final CategoryEntity entityObject) {
		return new Category(entityObject.getId(), entityObject.getName(), entityObject.getAvailable());
	}
}
