package io.hus.repository.categoryRepo;

import io.hus.entity.categoryEntity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    // HQL (Hibernate Query Language) is used to generate queries independent of the database used.
    @Query(value = "from Category c where c.status = 'CREATED'", nativeQuery = false)
    public List<Category> getCategories();

}
