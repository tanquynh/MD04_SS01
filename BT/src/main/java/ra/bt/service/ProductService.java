package ra.bt.service;



import ra.bt.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product saveOrUpdate(Product product);

    Product getProductById(Long id);

    void delete(Product product);
}
