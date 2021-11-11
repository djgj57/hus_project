package io.hus.service.categoryService;



import io.hus.entity.categoryEntity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> listAllCategory();
    public Category getCategory(Long id);
    public Category createCategory(Category category);
    public Category updateCategory(Category category);
    public  Category deleteCategory(Long id);
    public Category findByTitle(String title);
    public long countByTitle(String title);

}
