package io.hus.service.categoryService;


import io.hus.entity.categoryEntity.Category;
import io.hus.repository.categoryRepo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    final static Logger log = Logger.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listAllCategory() {
        log.info("Fetching all categories");
        return categoryRepository.getCategories();
    }

    @Override
    public Category getCategory(Long id) {
        log.info("Fetching category with id: " + id);
        Category result = categoryRepository.findById(id).orElse(null);
        if (result != null) {
            if (Objects.equals(result.getStatus(), "DELETED")) {
                return null;
            }
        }
        return result;
    }

    @Override
    public Category createCategory(Category category) {
        log.info("Saving new category: " + category.getTitle() + " to the database");
        category.setStatus("CREATED");
        category.setCreateAt(new Date());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        log.info("Update category: " + category.getTitle());
        Category categoryDB = getCategory(category.getId());
        if (null == categoryDB) {
            return null;
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(Long id) {
        Category categoryDB = getCategory(id);
        if (null == categoryDB) {
            log.error("Category not found in the database");
            return null;
        }
        log.info("Delete category with id " + id);
        categoryDB.setStatus("DELETED");
        return categoryRepository.save(categoryDB);
    }

    @Override
    public Category findByTitle(String title) {
        return categoryRepository.findByTitle(title).orElse(null);
    }

    @Override
    public long countByTitle(String title) {
        return categoryRepository.countByTitle(title);
    }


}
