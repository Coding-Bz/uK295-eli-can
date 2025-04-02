package ch.noseryoung.sbdemo01.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }


}


/*
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
*/
