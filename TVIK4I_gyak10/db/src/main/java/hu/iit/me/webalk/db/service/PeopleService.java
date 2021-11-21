package hu.iit.me.webalk.db.service;

public interface PeopleService {
    Iterable<People> getAllPeople();

    void delete(Long id);

    People create(People toPeople);

    People getById(Long id);

    void save(People toPeople);

    Iterable<? extends People> findByAgeGreaterThan(int age);
}
