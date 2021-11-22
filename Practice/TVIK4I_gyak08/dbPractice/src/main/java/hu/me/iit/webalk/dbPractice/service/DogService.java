package hu.me.iit.webalk.dbPractice.service;

public interface DogService {
    Iterable<Dog> getAllDog();
    void delete(Long id);
    Dog create(Dog toDog);
    Dog getById(Long id);
    void save(Dog toDog);

    Iterable<? extends Dog> findByAgeGreaterThan(int age);
}
