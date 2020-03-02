package netflix.core.category.useCase;

import java.util.Collection;

import lombok.AllArgsConstructor;
import netflix.core.category.Category;
import netflix.core.category.ports.input.GetAllCategoriesUseCase;
import netflix.core.category.ports.output.CategoryPersistenceService;

@AllArgsConstructor
public class GetAllCategoriesUseCaseImpl implements GetAllCategoriesUseCase {

	private final CategoryPersistenceService categoryPersistenceService;

	@Override
	public Collection<Category> execute() {
		return categoryPersistenceService.getAllCategories();
	}

}
