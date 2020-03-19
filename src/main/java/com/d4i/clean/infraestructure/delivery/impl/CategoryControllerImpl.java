package com.d4i.clean.infraestructure.delivery.impl;

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

import com.d4i.clean.core.category.usecase.CreateCategoryUseCase;
import com.d4i.clean.core.category.usecase.GetAllCategoriesUseCase;
import com.d4i.clean.infraestructure.delivery.CategoryController;
import com.d4i.clean.infraestructure.delivery.converters.CategoryRestConverter;
import com.d4i.clean.infraestructure.delivery.responses.NetflixResponse;
import com.d4i.clean.infraestructure.delivery.rest.CategoryRest;
import com.d4i.clean.infraestructure.shared.constants.CommonConstants;
import com.d4i.clean.infraestructure.shared.constants.RestConstants;
import com.d4i.clean.infraestructure.shared.exceptions.NetflixException;

import lombok.RequiredArgsConstructor;

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
