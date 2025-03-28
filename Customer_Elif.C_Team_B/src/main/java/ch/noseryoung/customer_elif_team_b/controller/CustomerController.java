package ch.noseryoung.customer_elif_team_b.controller;
import ch.noseryoung.customer_elif_team_b.exception.ResourceNotFoundException;
import ch.noseryoung.customer_elif_team_b.model.Customer;
import ch.noseryoung.customer_elif_team_b.repository.CustomerRepository;
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

    //get emplyoees

    @GetMapping("customers")
    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();

    }


@GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable (value = "id") UUID customerId)
    throws ResourceNotFoundException{
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: "+customerId));
    return ResponseEntity.ok().body(customer);


}

//save emplyoee
@PostMapping("customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return this.customerRepository.save(customer);
}
//update emplyoee
    @PutMapping("customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") UUID customerId,
       @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: "+customerId));
        customer.setEmail(customerDetails.getEmail());
        customer.setName(customerDetails.getName());
        customer.setPhone(customerDetails.getPhone());
        customer.setBirthday(customerDetails.getBirthday());

return ResponseEntity.ok(this.customerRepository.save(customer));
    }


//delete employee
    @DeleteMapping("customers/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") UUID customerId) throws ResourceNotFoundException {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: "+customerId));

this.customerRepository.delete(customer);
Map<String, Boolean> response = new HashMap<>();
response.put("deleted", Boolean.TRUE);
return response;
    }


}
