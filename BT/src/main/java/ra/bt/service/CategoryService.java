package ra.bt.service;



import ra.bt.entity.Category;

import java.util.List;


public interface CategoryService {
    List<Category> findAll();

    Category saveOrUpdate(Category category);

    Category findById(Long categoryId);

    void delete(Category category);
}
