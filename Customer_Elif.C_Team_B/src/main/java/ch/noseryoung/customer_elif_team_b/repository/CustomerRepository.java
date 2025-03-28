package ch.noseryoung.customer_elif_team_b.repository;
import ch.noseryoung.customer_elif_team_b.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public interface CustomerRepository extends JpaRepository<Customer, UUID>  {



}
