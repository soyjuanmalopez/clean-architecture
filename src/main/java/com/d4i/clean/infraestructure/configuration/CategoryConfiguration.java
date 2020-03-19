package com.d4i.clean.infraestructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.d4i.clean.core.category.usecase.CreateCategoryUseCaseImpl;
import com.d4i.clean.core.category.usecase.GetAllCategoriesUseCaseImpl;
import com.d4i.clean.infraestructure.delivery.converters.CategoryRestConverter;
import com.d4i.clean.infraestructure.persistence.converters.CategoryRepositoryConverter;
import com.d4i.clean.infraestructure.persistence.impl.CategoryServiceImpl;
import com.d4i.clean.infraestructure.persistence.repositories.CategoryRepository;

@Configuration
public class CategoryConfiguration {

	
	@Autowired
	private CategoryRepository categoryRepository;


	@Bean
	public CategoryRepositoryConverter createCategoryRepositoryConverter() {
		return new CategoryRepositoryConverter();
	}

	@Bean
	public CategoryRestConverter createCategoryRestConverter() {
		return new CategoryRestConverter();
	}

	@Bean
	public CategoryServiceImpl createCategoriServiceImpl() {
		return new CategoryServiceImpl(categoryRepository, createCategoryRepositoryConverter());
	}

	@Bean
	public GetAllCategoriesUseCaseImpl createGetAllCategoriesUseCase() {
		return new GetAllCategoriesUseCaseImpl(createCategoriServiceImpl());
	}
	
	@Bean
	public CreateCategoryUseCaseImpl createCreateCategoryUseCase() {
		return new CreateCategoryUseCaseImpl(createCategoriServiceImpl());
	}

}