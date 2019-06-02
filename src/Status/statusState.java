package Status;

public interface statusState {
    void next();
    void prev();
    void printStatus();
    void checkPossibleChangeInStatus();
    double getSpeed();
    String getTitle();
}
