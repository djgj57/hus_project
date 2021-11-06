package io.hus.service.productService;

import io.hus.entity.categoryEntity.Category;
import io.hus.entity.cityEntity.City;
import io.hus.entity.imageEntity.Image;
import io.hus.entity.productEntity.Product;
import io.hus.repository.imageRepo.ImageRepository;
import io.hus.repository.productRepo.ProductRepository;
import io.hus.service.imageService.ImageServiceImpl;
import io.hus.service.scoreService.ScoreService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor @Transactional
public class ProductServiceImpl implements ProductService {

    // TODO: Hacer todos los logguer
    final static Logger log = Logger.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ScoreService scoreService;

    @Override
    public Product createProduct(Product product) {
        log.info("Saving new product: " + product.getName() + " to the database");
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        log.info("Getting all products");
        List<Product> products = productRepository.findAll();
        products.forEach(product -> {
            try {
                product.setScore(scoreService.getScore(product.getId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return products;
    }

    @Override
    public List<Product> getProductsRandom() {
        List<Product> products = productRepository.getProductsRandom();
        products.forEach(product -> {
            try {
                product.setScore(scoreService.getScore(product.getId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return products;
    }

    @Override
    public List<Product> getProductByPages(Integer number) {
    log.info("Getting product by pages: " + number);
        List<Product> products = productRepository.getProductByPages(number);
        products.forEach(product -> {
            try {
                product.setScore(scoreService.getScore(product.getId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return products;

    }

    @Override
    public List<Product> getProductByCity(City nameCity) {
        log.info("Getting product by city: " + nameCity.getName());
        List<Product> products = productRepository.findByCity(nameCity);
        products.forEach(product -> {
            try {
                product.setScore(scoreService.getScore(product.getId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return products;
    }

    @Override
    public List<Product> getProductByCategory(Category nameCategory) {
        log.info("Getting product by category: " + nameCategory.getTitle());
        List<Product> products = productRepository.findByCategory(nameCategory);
        products.forEach(product -> {
            try {
                product.setScore(scoreService.getScore(product.getId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return products;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        log.info("Getting product with id " + id);
        Optional<Product> product = productRepository.findById(id);
        product.get().setScore(scoreService.getScore(product.get().getId()));
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        log.info("Update product: " + product.getName());
        Product productTem = productRepository.save(product);
        product.setScore(scoreService.getScore(productTem.getId()));
        return productTem;
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Delete product with id " + id);
        productRepository.deleteById(id);
    }

}
