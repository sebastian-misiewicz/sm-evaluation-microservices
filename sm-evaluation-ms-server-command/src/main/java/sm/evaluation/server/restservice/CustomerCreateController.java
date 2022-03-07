package sm.evaluation.server.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerCreateController {

    @GetMapping("/customer")
    public String get() {
        return "test";
    }

}
