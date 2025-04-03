package ch.noseryoung.customer_elif_team_b.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @GeneratedValue
    @Column(name = "coupon_id",  nullable = false)
    private UUID id;

@NotEmpty
    private String code;


    private String amount;

    @NotEmpty
    @Column(name = "expiry_date")
    private String expiryDate;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "customer_id", nullable = false)
@JsonBackReference
private Customer customer;

}
