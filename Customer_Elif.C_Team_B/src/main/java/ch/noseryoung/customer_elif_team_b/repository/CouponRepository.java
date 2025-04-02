package ch.noseryoung.customer_elif_team_b.repository;
import ch.noseryoung.customer_elif_team_b.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;



public interface CouponRepository extends JpaRepository<Coupon, UUID>  {



}
