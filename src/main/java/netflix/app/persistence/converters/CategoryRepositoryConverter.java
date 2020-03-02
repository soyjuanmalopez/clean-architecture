package netflix.app.persistence.converters;

import netflix.app.persistence.entities.CategoryEntity;
import netflix.app.utils.RepositoryConverter;
import netflix.core.category.Category;

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
