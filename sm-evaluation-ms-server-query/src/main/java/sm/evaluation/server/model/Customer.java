package sm.evaluation.server.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import sm.evaluation.server.event.CustomerCreated;

public class Customer {

    @Id
    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String email;

    public Customer() {
    }

    public Customer(CustomerCreated customerCreated) {
        this.id = customerCreated.getId();
        this.name = customerCreated.getName();
        this.email = customerCreated.getEmail();
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
