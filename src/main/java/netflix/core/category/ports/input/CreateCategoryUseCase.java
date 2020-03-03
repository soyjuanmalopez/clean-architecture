package netflix.core.category.ports.input;

import netflix.core.category.Category;
import netflix.core.utils.exceptions.NetflixException;

public interface CreateCategoryUseCase {

	public void execute(Category category) throws NetflixException;

}
