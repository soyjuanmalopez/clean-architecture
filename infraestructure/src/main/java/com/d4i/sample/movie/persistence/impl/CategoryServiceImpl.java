package com.d4i.sample.movie.persistence.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.ports.CategoryRepositoryService;
import com.d4i.sample.movie.persistence.converters.CategoryRepositoryConverter;
import com.d4i.sample.movie.persistence.repositories.CategoryRepository;
import com.d4i.sample.movie.shared.constants.ExceptionConstants;
import com.d4i.sample.movie.shared.exceptions.BadRequestException;
import com.d4i.sample.movie.shared.exceptions.NetflixException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryServiceImpl implements CategoryRepositoryService {

	private CategoryRepository categoryRepository;

	private CategoryRepositoryConverter categoryRepositoryConverter;

	@Override
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll().stream().map(category -> categoryRepositoryConverter.mapToEntity(category))
				.collect(Collectors.toList());
		
	}

	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(categoryRepositoryConverter.mapToTable(category));
	}

	public Boolean doesCategoryNameExists(String name) {
		return !categoryRepository.findByName(name).isEmpty();
	}

}
