package hu.iit.me.webalk.db.service;

public class NoSuchEntityException extends RuntimeException {

    private Long id;

    public NoSuchEntityException(Long id) {
        super(String.format("no such entityid", id));
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
