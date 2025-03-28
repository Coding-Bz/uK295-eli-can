package ch.noseryoung.customer_elif_team_b.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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

    @Column(name = "customer_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

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
   private Set<Coupon> coupons;

    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
        for (Coupon coupon : coupons) {
            coupon.setCustomer(this);
        }
    }


}
