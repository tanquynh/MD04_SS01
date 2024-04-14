package ra.bt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.bt.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
