package hu.iit.me.webalk.db.repository;

import hu.iit.me.webalk.db.repository.People;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<People, Long> {
    void delete(Long id);
}
