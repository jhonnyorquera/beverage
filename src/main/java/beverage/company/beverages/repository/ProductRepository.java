package beverage.company.beverages.repository;

import beverage.company.beverages.data.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


  Optional<Product> findFirstByNameAndStatus(String name, Boolean status);

}
