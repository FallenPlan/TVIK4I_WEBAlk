package com.example.licit.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface LicitRepository extends PagingAndSortingRepository<Licit, Long> {

    Optional<Licit> findTopByOrderByLicit();

    Optional<Licit> findTopByUserIdAndOrderByLicitDesk(int userId);
}
