package ra.bt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.bt.entity.Product;
import ra.bt.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIml implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceIml(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
