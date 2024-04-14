package ra.bt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ra.bt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
