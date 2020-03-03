package netflix.app.core.category.ports.input;

import java.util.Collection;

import netflix.app.core.category.Category;

public interface GetAllCategoriesUseCase {

	public Collection<Category> execute();
	
}
