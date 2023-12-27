package beverage.company.beverages.repository;

import beverage.company.beverages.data.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


  List<Customer> findByaliasAndStatus(String alias, Boolean status);

}
