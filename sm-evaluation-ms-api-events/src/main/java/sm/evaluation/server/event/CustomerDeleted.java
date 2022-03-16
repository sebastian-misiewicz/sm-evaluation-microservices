package sm.evaluation.server.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDeleted {

    @JsonProperty
    private String id;

    public CustomerDeleted() {
    }

    public CustomerDeleted(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
