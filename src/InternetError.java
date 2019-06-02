public class InternetError implements Error {
    @Override
    public int getWaitingTime() {
        return 0;
    }

    @Override
    public String getTitle() {
        return "internet error";
    }

    @Override
    public void handle(DownloadSystem ds) {
        ds.currentProcess.active=false;
        printMessage();
        while (ds.isInternetConnection()==false){

        }
        ds.currentProcess.active=true;
        System.out.println("exit "+getTitle());
    }

    @Override
    public void printMessage() {
        System.out.println("enter InternetError");
    }
}
