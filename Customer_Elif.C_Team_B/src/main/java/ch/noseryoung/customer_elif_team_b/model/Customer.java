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
    @NotEmpty(message = "Darf nicht leer sein")
    @NotBlank
    @Size(min=36, max=36)
    @NotEmpty
    @Column(name = "customer_id", updatable = false, nullable = false)
    private UUID id;

    @NotEmpty(message = "Darf nicht leer sein")
    @Column(name = "first_name")
    private String name;

    @NotBlank
    @Max(36)
    @Min(36)
    @NotEmpty(message = "Darf nicht leer sein")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Darf nicht leer sein")
    @Column(name = "phone")
    private String phone;


    @Email
    @Column(name = "birthday")
    private String birthday;


    public Customer(String name, String email, String phone, String birthday) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;

    }
    public UUID getID(){
        return id;
    }
    public void setID(UUID id){
        this.id = id;
    }


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
   private Set<Coupon> coupons;

    public Set<Coupon> getCoupons(){
        return coupons;
    }

    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
        for (Coupon coupon : coupons) {
            coupon.setCustomer(this);
        }
    }


}
