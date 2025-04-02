package ch.noseryoung.customer_elif_team_b.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="coupon")
public class Coupon {

    @Id

    @Column(name = "coupon_id", updatable = false, nullable = false)
    private UUID id;


    private String code;


    private String amount;

    @Column(name = "expiry_date")
    private String expiryDate;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "customer_id", nullable = false)
@JsonBackReference
private Customer customer;

}
