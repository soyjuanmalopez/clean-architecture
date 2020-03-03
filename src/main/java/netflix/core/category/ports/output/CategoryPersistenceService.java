package netflix.core.category.ports.output;

import java.util.Collection;

import netflix.core.category.Category;
import netflix.core.utils.exceptions.NetflixException;

public interface CategoryPersistenceService {

	public Collection<Category> getAllCategories();
	
	public void saveCategory(Category category) throws NetflixException;
}
