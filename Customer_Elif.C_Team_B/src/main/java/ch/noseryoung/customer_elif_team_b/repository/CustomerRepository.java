package ch.noseryoung.customer_elif_team_b.repository;
import ch.noseryoung.customer_elif_team_b.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CustomerRepository extends JpaRepository<Customer, UUID>  {

}
