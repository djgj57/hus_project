package io.hus.service.productService;

import io.hus.entity.imageEntity.Image;
import io.hus.entity.productEntity.Product;
import io.hus.repository.imageRepo.ImageRepository;
import io.hus.repository.productRepo.ProductRepository;
import io.hus.service.imageService.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // TODO: Hacer todos los logguer
    final static Logger log = Logger.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        log.info("Saving new product: " + product.getName() + " to the database");
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        log.info("Getting all products");
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsRandom() {
        return null;
    }

    @Override
    public List<Product> getProductByPages(Number number) {
        return null;
    }

    @Override
    public List<Product> getProductByCity(String Namecity) {
        return null;
    }

    @Override
    public List<Product> getProductByCategory(String Namecategory) {
        return null;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        log.info("Getting product with id " + id);
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        log.info("Update product: " + product.getName());
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Delete product with id " + id);
        productRepository.deleteById(id);
    }

}
