public interface Error {

    int getWaitingTime();
    String getTitle();
    void handle(DownloadSystem ds);
    void printMessage();

}
