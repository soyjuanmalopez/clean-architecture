package netflix.app.persistence.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import netflix.app.persistence.converters.CategoryRepositoryConverter;
import netflix.app.persistence.repositories.CategoryRepository;
import netflix.core.category.Category;
import netflix.core.category.ports.output.CategoryPersistenceService;
import netflix.core.utils.constants.ExceptionConstants;
import netflix.core.utils.exceptions.BadRequestException;
import netflix.core.utils.exceptions.NetflixException;

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
