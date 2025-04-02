package ch.noseryoung.customer_elif_team_b.controller;
import ch.noseryoung.customer_elif_team_b.model.Customer;
import ch.noseryoung.customer_elif_team_b.repository.CouponRepository;
import ch.noseryoung.customer_elif_team_b.repository.CustomerRepository;
import ch.noseryoung.customer_elif_team_b.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CustomerService customerService;


    //get emplyoees

    @GetMapping("customers")
    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();

    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }



@PutMapping("customers/{Id}")
public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer details) {
    return ResponseEntity.ok(customerService.updateCustomer(id, details));
}


    @DeleteMapping("/customers/{customerId}")
    public Map<String, Boolean> deleteCustomer(@PathVariable UUID customerId) {
        boolean deleted = customerService.deleteCustomer(customerId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return response;
    }



@PostMapping("/customers")
public Customer createCustomer(@Valid @RequestBody Customer customer) {
    return customerService.createCustomer(customer);
}


}


