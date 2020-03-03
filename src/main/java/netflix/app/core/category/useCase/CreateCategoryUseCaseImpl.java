package netflix.app.core.category.useCase;

import lombok.AllArgsConstructor;
import netflix.app.core.category.Category;
import netflix.app.core.category.ports.input.CreateCategoryUseCase;
import netflix.app.core.category.ports.output.CategoryPersistenceService;
import netflix.app.utils.constants.ExceptionConstants;
import netflix.app.utils.exceptions.BadRequestException;
import netflix.app.utils.exceptions.NetflixException;

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
