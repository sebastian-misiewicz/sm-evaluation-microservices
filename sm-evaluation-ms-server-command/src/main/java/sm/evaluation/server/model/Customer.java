package sm.evaluation.server.model;

import sm.evaluation.server.command.CreateCustomerCommand;

public class Customer {

    private final String name;

    private final String email;

    public Customer(CreateCustomerCommand createCustomerCommand) {
        this.name = createCustomerCommand.getName();
        this.email = createCustomerCommand.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}