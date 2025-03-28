package ch.noseryoung.customer_elif_team_b.controller;

import ch.noseryoung.customer_elif_team_b.exception.ResourceNotFoundException;
import ch.noseryoung.customer_elif_team_b.model.Customer;
import ch.noseryoung.customer_elif_team_b.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //get emplyoees

    @GetMapping("employees")
    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();

    }


@GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable (value = "id") Long customerId)
    throws ResourceNotFoundException{
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: "+customerId));
    return ResponseEntity.ok().body(customer);


}

//save emplyoee

}