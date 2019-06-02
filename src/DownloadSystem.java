import java.util.ArrayList;

///representing idle in state machine
public class DownloadSystem {
    boolean systemStatus=false;  //     on/off
    ArrayList<File> queue;
    double space=100;
    User user;
    DownloadProcess currentProcess=null;
    InternetConnection internet;


    //init user and queue
    public DownloadSystem(User user) {
        this.user=user;
        internet=new InternetConnection();
        queue=new ArrayList<>();
    }

    public void turnOn(){
        if(!systemStatus)
            System.out.println("exit turnOff DownloadSystem");
        System.out.println("enter turnOn DownloadSystem");
        systemStatus=true;
    }

    public void turnOff(){
        if(systemStatus)
            System.out.println("exit turnOn DownloadSystem");
        systemStatus=false;
        System.out.println("enter turnOff DownloadSystem");
    }

    public void fileRequest(){
        if (queue.size()>0) {
            File firstFile = queue.remove(0);
            currentProcess=new DownloadProcess(this,firstFile);
            currentProcess.download();
        }
    }
    //added new file to queue
    public void addNewFile(File newFile){
      queue.add(newFile);
    }

    //delete file from queue
    public void downloadAborted(int fileId){
        for (int i=0;i<queue.size();i++) {
            if (queue.get(i).getFileId()==fileId) {
                queue.remove(i);
                break;
            }
        }

        user.status.setPoints(user.status.getPoints()-1);
        user.status.getCurrentState().checkPossibleChangeInStatus();
    }

    //pause current download process
    public void pauseDownloadProcess(){
        currentProcess.active=false;
    }

    //resume download of current process
    public void resumeDownload(){
        currentProcess.active=true;
    }

    public boolean isInternetConnection(){
        return internet.active;
    }


}
