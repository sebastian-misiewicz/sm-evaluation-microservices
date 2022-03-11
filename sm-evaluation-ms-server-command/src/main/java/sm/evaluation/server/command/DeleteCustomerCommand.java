package sm.evaluation.server.command;

public class DeleteCustomerCommand {

    private final String email;

    public DeleteCustomerCommand(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
