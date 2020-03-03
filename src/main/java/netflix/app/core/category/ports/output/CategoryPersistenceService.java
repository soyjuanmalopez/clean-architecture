package netflix.app.core.category.ports.output;

import java.util.Collection;

import netflix.app.core.category.Category;
import netflix.app.utils.exceptions.NetflixException;

public interface CategoryPersistenceService {

	public Collection<Category> getAllCategories();
	
	public void saveCategory(Category category) throws NetflixException;
}
