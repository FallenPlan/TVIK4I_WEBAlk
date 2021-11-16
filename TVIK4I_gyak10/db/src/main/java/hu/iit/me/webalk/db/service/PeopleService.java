package hu.iit.me.webalk.db.service;


import hu.iit.me.webalk.db.repository.People;

public interface PeopleService {
    Iterable<People> getAllPeople();

    public void delete(Long id);

    People create(People toPeople);

    People getById(Long id);

    void save(People toPeople);
}
