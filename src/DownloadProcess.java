import java.util.ArrayList;

public class DownloadProcess implements Subject{
    double processPercent;
    DownloadSystem ds;
    File file;
    boolean active;
    boolean downloadProblem;
    ArrayList <Observer> observers;
    Player player;

    public DownloadProcess(DownloadSystem system,File f) {
        this.processPercent =0;
        ds=system;
        file=f;
        downloadProblem=false;
        observers=new ArrayList<>();
        player =new Player();
        observers.add(player);
    }

    public double getProcessPercent() {
        return processPercent;
    }

    public File getFile() {
        return file;
    }

    public void download(){
        active=true;
        //check space problem
        if (ds.space-file.getFileSize()<0) {
            Error e = new NoSpaceError();
            e.handle(ds);
        }

        //in case of internet problem
        else if(ds.isInternetConnection()==false ){
            Error e=new InternetError();
            e.handle(ds);
        }

        else if (downloadProblem){
            Error e= new DownloadProblemError();
            e.handle(ds);
        }

        if (active){
            while (processPercent <100 ){
                double speed=ds.user.status.getCurrentState().getSpeed();
                processPercent=processPercent+speed;

                if (processPercent>=20)
                  notifyObservers();
            }

            processPercent=100;
            ds.space=ds.space-file.getFileSize();
           System.out.println("download completed!");
            notifyObservers();
           ds.user.status.setPoints(ds.user.status.getPoints()+1);
           ds.user.status.getCurrentState().checkPossibleChangeInStatus();
       }


    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        if (processPercent >= 100) {
            for (Observer o : observers) {
                o.update(1);
            }
        } else if (processPercent >= 20) {
            for (Observer o : observers) {
                o.update(0);
            }
        }
    }
}
