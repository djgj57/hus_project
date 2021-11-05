package io.hus.repository.productRepo;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.cityEntity.City;
import io.hus.entity.productEntity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
    public List<Product> findByCity(City city);

    @Query(value = "SELECT * FROM hus_db.tbl_products order by RAND() limit 8", nativeQuery = true)
    public List<Product> getProductsRandom();


    @Query(value = "(SELECT * FROM tbl_products limit ?1, 8)", nativeQuery = true)
    public List<Product> getProductByPages(Integer page);


}

