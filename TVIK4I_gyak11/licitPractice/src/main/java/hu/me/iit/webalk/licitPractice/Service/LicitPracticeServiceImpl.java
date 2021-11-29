package hu.me.iit.webalk.licitPractice.Service;

import hu.me.iit.webalk.licitPractice.Repository.LicitPractice;
import hu.me.iit.webalk.licitPractice.Repository.LicitPracticeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicitPracticeServiceImpl implements LicitPracticeService {
    private final LicitPracticeRepository licitPracticeRepository;

    public LicitPracticeServiceImpl(LicitPracticeRepository licitPracticeRepository) {
        this.licitPracticeRepository = licitPracticeRepository;
    }

    @Override
    public int getLowest() {
        Optional<LicitPractice> result = licitPracticeRepository.findBottomByOrderByLicitDesc();

        if(result.isEmpty()) {
            return 0;
        }
        return result.get().getLicit();
    }

    @Override
    public int getLowestForUser(int userId) {
        Optional<LicitPractice> result = licitPracticeRepository.findBottomByUserIdOrderByLicitDesc(userId);

        if(result.isEmpty()) {
            return 0;
        }
        return result.get().getLicit();
    }

    @Override
    public void saveNewLicit(int licit, int userId) {
        licitPracticeRepository.save(new LicitPractice(licit, userId));
    }
}
