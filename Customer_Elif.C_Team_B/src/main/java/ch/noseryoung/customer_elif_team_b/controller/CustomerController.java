package ch.noseryoung.customer_elif_team_b.controller;
import ch.noseryoung.customer_elif_team_b.model.Coupon;
import ch.noseryoung.customer_elif_team_b.model.Customer;
import ch.noseryoung.customer_elif_team_b.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@Valid @PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable UUID id, @RequestBody Customer details) throws Exception {
        return new ResponseEntity<>(customerService.updateCustomer(id, details), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@Valid @PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/coupon/{couponId}")
    public ResponseEntity<Coupon> getCoupon(@Valid @PathVariable("couponId") UUID couponId) {
        return new ResponseEntity<>(customerService.getCouponById(couponId), HttpStatus.OK);
    }

    @PostMapping("/coupon")
    public ResponseEntity<Coupon> createCoupon(@Valid @RequestBody Coupon coupon) {
        return new ResponseEntity<>(customerService.createCoupon(coupon), HttpStatus.CREATED);
    }

    @PutMapping("/coupon/{id}")
    public ResponseEntity<Coupon> updateCoupon(@Valid @PathVariable UUID id, @RequestBody Coupon details) throws Exception {
        return new ResponseEntity<>(customerService.updateCoupon(id, details), HttpStatus.OK);
    }

    @DeleteMapping("/coupon/{couponId}")
    public ResponseEntity<Void> deleteCoupon(@Valid @PathVariable("couponId") UUID couponId) {
        customerService.deleteCoupon(couponId);
        return ResponseEntity.noContent().build();
    }
}