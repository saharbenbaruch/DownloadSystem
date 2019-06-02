package Status;

import Status.Status;

public class Advanced implements statusState {
    Status status;
    String title="Advanced";
    double speed=1.2;
    public Advanced(Status status){
    this.status=status;
    }
    public double getSpeed() {
        return speed;
    }

    @Override
    public void next() {
        status.setStatusState(status.professional);
    }

    @Override
    public void prev() {
        status.setStatusState(status.beginner);
    }

    @Override
    public void printStatus() {
        System.out.println("enter "+title);
    }

    @Override
    public void checkPossibleChangeInStatus() {
        if (status.getPoints()>=7)
            next();

        else if (status.getPoints()<4)
            prev();
    }
    @Override
    public String getTitle() {
        return title;
    }
}
