package netflix.core.category.ports.output;

import java.util.Collection;

import netflix.core.category.Category;

public interface CategoryPersistenceService {

	public Collection<Category> getAllCategories();
}
