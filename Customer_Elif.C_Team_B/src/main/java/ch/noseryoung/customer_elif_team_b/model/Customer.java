package ch.noseryoung.customer_elif_team_b.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;


@Entity
@Table(name="customer")
public class Customer {


    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "birthday")
    private String birthday;



//Default Konstruktor

    public Customer() {
        super();
    }

    public Customer(String phone, String name, String email, String birthday) {
        super();
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
