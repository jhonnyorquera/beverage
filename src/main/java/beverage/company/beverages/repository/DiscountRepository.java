package beverage.company.beverages.repository;

import beverage.company.beverages.data.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {

}
