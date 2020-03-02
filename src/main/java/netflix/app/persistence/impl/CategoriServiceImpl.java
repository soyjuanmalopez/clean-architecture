package netflix.app.persistence.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import netflix.app.persistence.converters.CategoryRepositoryConverter;
import netflix.app.persistence.repositories.CategoryRepository;
import netflix.core.category.Category;
import netflix.core.category.ports.output.CategoryPersistenceService;

@AllArgsConstructor
public class CategoriServiceImpl implements CategoryPersistenceService {

	private CategoryRepository categoryRepository;

	private CategoryRepositoryConverter categoryRepositoryConverter;

	@Override
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll().stream().map(category -> categoryRepositoryConverter.mapToEntity(category))
				.collect(Collectors.toList());
	}

}
