package sm.evaluation.server.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerCreated {

    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String email;

    public CustomerCreated() {
    }

    public CustomerCreated(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
