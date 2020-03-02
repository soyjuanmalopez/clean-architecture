package netflix.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import netflix.app.persistence.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
