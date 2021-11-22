package hu.me.iit.webalk.dbPractice.service;

public class NoSuchEntityException extends RuntimeException {

    private Long id;

    public NoSuchEntityException(Long id) {
        super(String.format("no such entity%d", id));
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
