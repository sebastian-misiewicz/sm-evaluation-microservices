package sm.evaluation.server.command;

public class CreateCustomerCommand {

    private String name;

    private String mail;

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }
}
