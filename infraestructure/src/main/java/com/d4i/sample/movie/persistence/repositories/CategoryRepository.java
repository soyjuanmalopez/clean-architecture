package com.d4i.sample.movie.persistence.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.persistence.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	public Collection<Category> findByName(String name);
}
