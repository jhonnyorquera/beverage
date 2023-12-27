package beverage.company.beverages.repository;

import beverage.company.beverages.data.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


  List<Product> findByNameAndStatus(String name, Boolean status);

}
