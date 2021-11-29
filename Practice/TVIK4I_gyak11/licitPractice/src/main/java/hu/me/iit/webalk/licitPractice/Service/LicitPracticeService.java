package hu.me.iit.webalk.licitPractice.Service;

public interface LicitPracticeService {
    int getLowest();
    int getLowestForUser(int userId);
    void saveNewLicit(int licit, int userId);
}
