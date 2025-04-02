package ch.noseryoung.customer_elif_team_b.service;
import ch.noseryoung.customer_elif_team_b.model.Customer;
import ch.noseryoung.customer_elif_team_b.model.Coupon;
import ch.noseryoung.customer_elif_team_b.repository.CustomerRepository;
import ch.noseryoung.customer_elif_team_b.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CouponRepository couponRepository;

    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        if (customer.getCoupons() != null) {
            for (Coupon coupon : customer.getCoupons()) {
                coupon.setCustomer(savedCustomer);
                couponRepository.save(coupon);
            }
        }

        return savedCustomer;
    }

    public Customer updateCustomer(UUID customerId, Customer customerDetails) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setEmail(customerDetails.getEmail());
        customer.setName(customerDetails.getName());
        customer.setPhone(customerDetails.getPhone());
        customer.setBirthday(customerDetails.getBirthday());

        return customerRepository.save(customer);
    }


    public Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public boolean deleteCustomer(UUID customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
        return true;
    }



}
