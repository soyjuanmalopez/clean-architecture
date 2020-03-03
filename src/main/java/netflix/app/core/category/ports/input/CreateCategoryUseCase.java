package netflix.app.core.category.ports.input;

import netflix.app.core.category.Category;
import netflix.app.utils.exceptions.NetflixException;

public interface CreateCategoryUseCase {

	public void execute(Category category) throws NetflixException;

}
