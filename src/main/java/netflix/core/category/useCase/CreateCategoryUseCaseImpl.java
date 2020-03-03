package netflix.core.category.useCase;

import lombok.AllArgsConstructor;
import netflix.core.category.Category;
import netflix.core.category.ports.input.CreateCategoryUseCase;
import netflix.core.category.ports.output.CategoryPersistenceService;
import netflix.core.utils.constants.ExceptionConstants;
import netflix.core.utils.exceptions.BadRequestException;
import netflix.core.utils.exceptions.NetflixException;

@AllArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

	private final CategoryPersistenceService categoryPersistenceService;

	@Override
	public void execute(Category category) throws NetflixException {

		if (category.getName().length() > 25)
			throw new BadRequestException(ExceptionConstants.BAD_REQUEST_DEFAULT_MESSAGE);
		
		categoryPersistenceService.saveCategory(category);
	}

}
