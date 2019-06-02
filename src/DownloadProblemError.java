import java.util.concurrent.TimeUnit;

public class DownloadProblemError implements Error {
    @Override
    public int getWaitingTime() {
        return 3;
    }

    @Override
    public String getTitle() {
        return "DownloadProblemError";
    }

    @Override
    public void handle(DownloadSystem ds) {
        printMessage();
        ds.currentProcess.active=false;
        try {
            TimeUnit.SECONDS.sleep(getWaitingTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //return the file space to memory, if problem didn't fixed
        if (ds.currentProcess.downloadProblem) {
            ds.space = ds.space + ds.currentProcess.file.getFileSize();
            ds.user.status.setPoints(ds.user.status.getPoints()-1);
            ds.user.status.getCurrentState().checkPossibleChangeInStatus();
        }
        //problem fixed
        else{
            ds.currentProcess.active=true;
            System.out.println("exit "+getTitle());
        }
    }

    @Override
    public void printMessage() {
        System.out.println("enter "+getTitle());
    }
}
