package ch.noseryoung.sbdemo01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class HelloController {



@GetMapping("/")
    public String today() {

        return "Today is a nice day ";

}


    @GetMapping("/")
    public String index() {
        return "Today is a bad day ";

    }

}

