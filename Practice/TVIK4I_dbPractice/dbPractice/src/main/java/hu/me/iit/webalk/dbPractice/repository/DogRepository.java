package hu.me.iit.webalk.dbPractice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface DogRepository extends PagingAndSortingRepository<Dog, Long> {
    Iterable<Dog> findAllByAgeGreaterThanEqual(int age);
}
