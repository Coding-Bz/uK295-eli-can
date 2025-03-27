package ch.noseryoung.sbdemo01.domain.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProductController {



    @GetMapping("/api/v1/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable UUID productId) {
        Product p = new Product(productId, "Sneakers", "Cool Shoes!", 50.20);
return new ResponseEntity<>(p, HttpStatus.OK);
    }


    @GetMapping("/Greeting")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.status(200).body("Hello World");
    }


    @GetMapping("/GreetingAgain")
    public ResponseEntity<String> getGreetingHello() {
        return ResponseEntity.status(HttpStatus.OK).body("Again, hello!");
    }

}