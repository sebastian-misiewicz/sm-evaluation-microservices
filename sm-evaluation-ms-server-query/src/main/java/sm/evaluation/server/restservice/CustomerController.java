package sm.evaluation.server.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sm.evaluation.server.model.Customer;

@RestController
public class CustomerController {

    @GetMapping("/customer")
    public Customer get(@RequestParam(value = "name", defaultValue = "Test Company") String name) {
        return new Customer(name, "test@email.com");
    }

}
