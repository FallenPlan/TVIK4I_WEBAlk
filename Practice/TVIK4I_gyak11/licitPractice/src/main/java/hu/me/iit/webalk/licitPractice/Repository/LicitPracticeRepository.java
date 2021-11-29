package hu.me.iit.webalk.licitPractice.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface LicitPracticeRepository extends PagingAndSortingRepository<LicitPractice, Long> {
    Optional<LicitPractice> findBottomByOrderByLicitDesc();
    Optional<LicitPractice> findBottomByUserIdOrderByLicitDesc(int userId);
}
