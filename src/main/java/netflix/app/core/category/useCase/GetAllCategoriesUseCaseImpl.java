package netflix.app.core.category.useCase;

import java.util.Collection;

import lombok.AllArgsConstructor;
import netflix.app.core.category.Category;
import netflix.app.core.category.ports.input.GetAllCategoriesUseCase;
import netflix.app.core.category.ports.output.CategoryPersistenceService;

@AllArgsConstructor
public class GetAllCategoriesUseCaseImpl implements GetAllCategoriesUseCase {

	private final CategoryPersistenceService categoryPersistenceService;

	@Override
	public Collection<Category> execute() {
		return categoryPersistenceService.getAllCategories();
	}

}
