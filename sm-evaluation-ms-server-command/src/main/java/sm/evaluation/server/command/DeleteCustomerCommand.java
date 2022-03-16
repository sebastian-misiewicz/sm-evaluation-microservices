package sm.evaluation.server.command;

public class DeleteCustomerCommand {

    private final String id;

    public DeleteCustomerCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
