package io.hus.service.productService;

import io.hus.entity.productEntity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product createProduct(Product product);

    public List<Product> getProducts();
    public List<Product> getProductsRandom();
    public List<Product> getProductByPages(Number number);
    public List<Product> getProductByCity(String Namecity);
    public List<Product> getProductByCategory(String Namecategory);
    public  Optional<Product> getProduct(Long id);
    public Product updateProduct(Product product);
    public void deleteProduct(Long id);
}

