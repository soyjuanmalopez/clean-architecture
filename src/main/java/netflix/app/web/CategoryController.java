package netflix.app.web;

import java.util.Collection;

import netflix.app.web.responses.NetflixResponse;
import netflix.app.web.rest.CategoryRest;
import netflix.core.utils.exceptions.NetflixException;

public interface CategoryController {

	NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<Boolean> createCategory(CategoryRest category) throws NetflixException;

}
