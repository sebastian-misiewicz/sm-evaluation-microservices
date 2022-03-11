package sm.evaluation.server.model;

import org.springframework.data.annotation.Id;

public class Customer {

    private final String name;

    @Id
    private final String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
