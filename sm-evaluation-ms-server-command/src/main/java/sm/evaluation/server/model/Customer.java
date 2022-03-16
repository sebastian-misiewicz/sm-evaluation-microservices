package sm.evaluation.server.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import sm.evaluation.server.command.CreateCustomerCommand;

public class Customer {

    @Id
    @JsonProperty
    private String email;

    @JsonProperty
    private String name;

    public Customer(CreateCustomerCommand createCustomerCommand) {
        this.name = createCustomerCommand.getName();
        this.email = createCustomerCommand.getEmail();
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}