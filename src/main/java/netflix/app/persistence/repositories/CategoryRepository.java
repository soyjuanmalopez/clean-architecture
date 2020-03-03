package netflix.app.persistence.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import netflix.app.persistence.entities.CategoryEntity;
import netflix.core.category.Category;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	public Collection<Category> findByName(String name);
}
