package Status;

public class Professional implements statusState {
    Status status;
    String title = "Professional";
    double speed=1.5;
    public Professional(Status status){
        this.status=status;

    }
    public double getSpeed() {
        return speed;
    }

    @Override
    public void next() {

    }

    @Override
    public void prev() {
        status.setStatusState(status.advanced);
    }

    @Override
    public void printStatus() {
        System.out.println("enter "+title);
    }

    @Override
    public void checkPossibleChangeInStatus() {
        if (status.getPoints()<7)
            prev();
    }
    @Override
    public String getTitle() {
        return title;
    }
}
