package netflix.app.web.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import netflix.app.utils.constants.CommonConstants;
import netflix.app.utils.constants.RestConstants;
import netflix.app.web.CategoryController;
import netflix.app.web.converters.CategoryRestConverter;
import netflix.app.web.responses.NetflixResponse;
import netflix.app.web.rest.CategoryRest;
import netflix.core.category.ports.input.GetAllCategoriesUseCase;
import netflix.core.utils.exceptions.NetflixException;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CATEGORY)
@AllArgsConstructor
public class CategoryControllerImpl implements CategoryController {

	private GetAllCategoriesUseCase getAllCategoriesUseCase;

	private CategoryRestConverter categoryRestConverter;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				getAllCategoriesUseCase.execute().stream().map(category -> categoryRestConverter.mapToRest(category))
						.collect(Collectors.toList()));
	}

}
