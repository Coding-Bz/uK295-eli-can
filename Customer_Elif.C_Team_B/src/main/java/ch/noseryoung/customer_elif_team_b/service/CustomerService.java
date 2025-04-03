package ch.noseryoung.customer_elif_team_b.service;
import ch.noseryoung.customer_elif_team_b.model.Customer;
import ch.noseryoung.customer_elif_team_b.model.Coupon;
import ch.noseryoung.customer_elif_team_b.repository.CustomerRepository;
import ch.noseryoung.customer_elif_team_b.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;

    @Autowired
    public CustomerService(CouponRepository couponRepository, CustomerRepository customerRepository) {
        this.couponRepository = couponRepository;
        this.customerRepository = customerRepository;
    }

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

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public Customer updateCustomer(UUID customerId, Customer customerDetails) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setEmail(customerDetails.getEmail());
        customer.setName(customerDetails.getName());
        customer.setPhone(customerDetails.getPhone());
        customer.setBirthday(customerDetails.getBirthday());
        customer.setCoupons(customerDetails.getCoupons());

        return customerRepository.save(customer);
    }


    public Coupon updateCoupon(UUID couponId, Coupon couponDetails) {
        Coupon coupon= couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));
                coupon.setAmount(couponDetails.getAmount());
                coupon.setCode(couponDetails.getCode());
                coupon.setExpiryDate(couponDetails.getExpiryDate());

                return couponRepository.save(coupon);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Coupon getCouponById(UUID couponId) {
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));
    }

    public void deleteCustomer(UUID customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
    }

    public void deleteCoupon(UUID couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));
        couponRepository.delete(coupon);
    }
}