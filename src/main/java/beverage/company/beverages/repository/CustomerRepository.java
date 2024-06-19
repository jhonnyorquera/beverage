package beverage.company.beverages.repository;

import beverage.company.beverages.data.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


  Optional<Customer> findFirstByAliasAndStatus(String alias, Boolean status);

}
