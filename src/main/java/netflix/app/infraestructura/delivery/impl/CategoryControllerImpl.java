package netflix.app.infraestructura.delivery.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import netflix.app.core.category.ports.input.CreateCategoryUseCase;
import netflix.app.core.category.ports.input.GetAllCategoriesUseCase;
import netflix.app.infraestructura.delivery.CategoryController;
import netflix.app.infraestructura.delivery.converters.CategoryRestConverter;
import netflix.app.infraestructura.delivery.responses.NetflixResponse;
import netflix.app.infraestructura.delivery.rest.CategoryRest;
import netflix.app.utils.constants.CommonConstants;
import netflix.app.utils.constants.RestConstants;
import netflix.app.utils.exceptions.NetflixException;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CATEGORY)
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {

	private final GetAllCategoriesUseCase getAllCategoriesUseCase;

	private final CreateCategoryUseCase createCategoryUseCase;

	private final CategoryRestConverter categoryRestConverter;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				getAllCategoriesUseCase.execute().stream().map(category -> categoryRestConverter.mapToRest(category))
						.collect(Collectors.toList()));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<Boolean> createCategory(@Valid @RequestBody final CategoryRest category) throws NetflixException {
		
		createCategoryUseCase.execute(categoryRestConverter.mapToEntity(category));
		
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
	}

}
