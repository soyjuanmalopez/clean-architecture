package netflix.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import netflix.app.core.category.useCase.CreateCategoryUseCaseImpl;
import netflix.app.core.category.useCase.GetAllCategoriesUseCaseImpl;
import netflix.app.infraestructura.delivery.converters.CategoryRestConverter;
import netflix.app.infraestructura.persistence.converters.CategoryRepositoryConverter;
import netflix.app.infraestructura.persistence.impl.CategoriServiceImpl;
import netflix.app.infraestructura.persistence.repositories.CategoryRepository;

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