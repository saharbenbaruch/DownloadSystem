package Status;

import Status.Status;

public class Beginner implements statusState {
    Status status;
    String title="Beginner";
    double speed=1;

    public Beginner(Status status){
this.status=status;

}
    @Override
    public void next() {
        status.setStatusState(status.advanced);
    }

    @Override
    public void prev() {

    }

    @Override
    public void printStatus() {
        System.out.println("enter "+title);
    }

    @Override
    public void checkPossibleChangeInStatus() {
        if (status.getPoints()>=4)
            next();
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
