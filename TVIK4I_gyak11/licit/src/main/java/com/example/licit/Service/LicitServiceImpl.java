package com.example.licit.Service;

import com.example.licit.Repository.Licit;
import com.example.licit.Repository.LicitRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicitServiceImpl implements LicitService {
    private final LicitRepository licitRepository;

    public LicitServiceImpl(LicitRepository licitRepository) {
        this.licitRepository = licitRepository;
    }

    @Override
    public int getHighest() {
        Optional<Licit> result = licitRepository.findTopByOrderByLicit();

        if(result.isEmpty()) {
            return 0;
        }
        return result.get().getLicit();
//        return licitRepository.findTopByOrderByLicit().getLicit();
    }

    @Override
    public int getHighestForUser(int userId) {
        Optional<Licit> result = licitRepository.findTopByUserIdAndOrderByLicitDesk(userId);

        if(result.isEmpty()) {
            return 0;
        }
        return result.get().getLicit();
//        return licitRepository.findTopByUserIdAndOrderByLicitDesk(userId).getLicit();
    }

    @Override
    public void saveNewLicit(int licit, int userId) {
        licitRepository.save(new Licit(licit, userId));
    }

}
