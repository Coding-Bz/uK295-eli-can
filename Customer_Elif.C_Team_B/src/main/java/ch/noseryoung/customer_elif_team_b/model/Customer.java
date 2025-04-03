package ch.noseryoung.customer_elif_team_b.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


import java.util.Set;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id", updatable = false, nullable = false)
    private UUID id;

    @NotEmpty(message = "Darf nicht leer sein")
    @Column(name = "first_name")
    private String name;

    @NotBlank
    @Email
    @NotEmpty(message = "Darf nicht leer sein")
    private String email;

    @NotEmpty(message = "Darf nicht leer sein")
    private String phone;


    private String birthday;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
   private Set<Coupon> coupons;

}
