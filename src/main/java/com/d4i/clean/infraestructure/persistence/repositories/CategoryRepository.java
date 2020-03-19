package com.d4i.clean.infraestructure.persistence.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d4i.clean.core.category.Category;
import com.d4i.clean.infraestructure.persistence.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	public Collection<Category> findByName(String name);
}
