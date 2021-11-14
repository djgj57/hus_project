package io.hus.service.productService;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.cityEntity.City;
import io.hus.entity.productEntity.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product createProduct(Product product);

    public List<Product> getProducts();
    public List<Product> getProductsRandom();
    public List<Product> getProductByPages(Integer number);
    public List<Product> getProductByCity(City nameCity);
    public List<Product> getProductByCategory(Category nameCategory);
    public  Optional<Product> getProduct(Long id);
    public Product updateProduct(Product product);
    public void deleteProduct(Long id);
    public List<Product> getProductsDisableByDates(String startDate, String endDate, Long id);
}

