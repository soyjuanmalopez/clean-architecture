package netflix.app.infraestructura.delivery;

import java.util.Collection;

import netflix.app.infraestructura.delivery.responses.NetflixResponse;
import netflix.app.infraestructura.delivery.rest.CategoryRest;
import netflix.app.utils.exceptions.NetflixException;

public interface CategoryController {

	NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<Boolean> createCategory(CategoryRest category) throws NetflixException;

}
