import java.util.concurrent.TimeUnit;

public class NoSpaceError implements Error {
    String title ="";
    int time;

    public NoSpaceError(){
        title="NoSpaceError";
        time=4;
    }

    @Override
    public int getWaitingTime() {
        return time;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void handle(DownloadSystem ds) {
        ds.currentProcess.active=false;
        printMessage();
        //wait 4 sec !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        try {
            TimeUnit.SECONDS.sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //return the file space to memory, if problem didn't fixed
        if (ds.space-ds.currentProcess.file.getFileSize()<0) {
            ds.space = ds.space + ds.currentProcess.file.getFileSize();
            ds.user.status.setPoints(ds.user.status.getPoints()-1);
            ds.user.status.getCurrentState().checkPossibleChangeInStatus();

        }
        //problem fixed
        else{
            ds.currentProcess.active=true;
        }
        System.out.println("exit "+getTitle());

    }
    @Override
    public void printMessage(){
        System.out.println("enter "+getTitle());
    }
}
