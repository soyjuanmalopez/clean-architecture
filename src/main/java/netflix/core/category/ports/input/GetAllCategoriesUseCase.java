package netflix.core.category.ports.input;

import java.util.Collection;

import netflix.core.category.Category;

public interface GetAllCategoriesUseCase {

	public Collection<Category> execute();
	
}
