package netflix.app.infraestructura.persistence.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import netflix.app.core.category.Category;
import netflix.app.infraestructura.persistence.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	public Collection<Category> findByName(String name);
}
