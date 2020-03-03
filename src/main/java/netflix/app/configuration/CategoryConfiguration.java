package netflix.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import netflix.app.persistence.converters.CategoryRepositoryConverter;
import netflix.app.persistence.impl.CategoriServiceImpl;
import netflix.app.persistence.repositories.CategoryRepository;
import netflix.app.web.converters.CategoryRestConverter;
import netflix.core.category.useCase.CreateCategoryUseCaseImpl;
import netflix.core.category.useCase.GetAllCategoriesUseCaseImpl;

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
	public CategoriServiceImpl createCategoriServiceImpl() {
		return new CategoriServiceImpl(categoryRepository, createCategoryRepositoryConverter());
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