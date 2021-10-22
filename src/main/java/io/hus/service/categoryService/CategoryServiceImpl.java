package io.hus.service.categoryService;


import io.hus.entity.categoryEntity.Category;
import io.hus.repository.categoryRepo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listAllCategory() {
        return categoryRepository.getCategories();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        category.setStatus("CREATED");
        category.setCreateAt(new Date());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category categoryDB = getCategory(category.getId());
        if (null == categoryDB){
            return null;
        }
        return  categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(Long id) {
        Category categoryDB = getCategory(id);
        if (null == categoryDB){
            return null;
        }
        categoryDB.setStatus("DELETED");
        return categoryRepository.save(categoryDB);
    }
}
