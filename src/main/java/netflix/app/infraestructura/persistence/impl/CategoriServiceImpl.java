package netflix.app.infraestructura.persistence.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import netflix.app.core.category.Category;
import netflix.app.core.category.ports.output.CategoryPersistenceService;
import netflix.app.infraestructura.persistence.converters.CategoryRepositoryConverter;
import netflix.app.infraestructura.persistence.repositories.CategoryRepository;
import netflix.app.utils.constants.ExceptionConstants;
import netflix.app.utils.exceptions.BadRequestException;
import netflix.app.utils.exceptions.NetflixException;

@AllArgsConstructor
public class CategoriServiceImpl implements CategoryPersistenceService {

	private CategoryRepository categoryRepository;

	private CategoryRepositoryConverter categoryRepositoryConverter;

	@Override
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll().stream().map(category -> categoryRepositoryConverter.mapToEntity(category))
				.collect(Collectors.toList());
	}

	@Override
	public void saveCategory(Category category) throws NetflixException {
		if (doesCategoryNameExists(category.getName()))
			throw new BadRequestException(ExceptionConstants.BAD_REQUEST_EXISTS_CATEGORY_MESSAGE);
		categoryRepository.save(categoryRepositoryConverter.mapToTable(category));
	}

	private Boolean doesCategoryNameExists(String name) {
		return !categoryRepository.findByName(name).isEmpty();
	}

}
