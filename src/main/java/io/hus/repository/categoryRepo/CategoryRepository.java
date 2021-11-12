package io.hus.repository.categoryRepo;

import io.hus.entity.categoryEntity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    // HQL (Hibernate Query Language) is used to generate queries independent of the database used.
    @Query(value = "from Category c where c.status = 'CREATED'", nativeQuery = false)
    public List<Category> getCategories();


    // find by title
    public Optional<Category> findByTitle(String title);

    // Count by title
    @Query(value = "select count(p) from Product p where p.category.title = ?1")
    public long countByTitle(String title);


//    Ejemplo:
//    @Query("SELECT o FROM Odontologo o WHERE o.matricula = ?1")
//    Odontologo findOdontologoByMatricula(Integer matricula);

}
