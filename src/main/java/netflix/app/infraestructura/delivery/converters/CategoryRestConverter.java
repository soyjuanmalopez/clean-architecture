package netflix.app.infraestructura.delivery.converters;

import netflix.app.core.category.Category;
import netflix.app.infraestructura.delivery.rest.CategoryRest;
import netflix.app.utils.RestConverter;

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
