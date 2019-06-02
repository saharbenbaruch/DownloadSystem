package Status;

public class Status {
    int points=1;
    double speed;

 statusState beginner;
 statusState advanced;
 statusState professional;

 statusState currentState;

    public Status(){
       beginner=new Beginner(this);
       advanced=new Advanced(this);
       professional=new Professional(this);

       currentState=new Beginner(this);

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    void setStatusState(statusState newStatusState){
        System.out.println("exit "+currentState.getTitle());
        currentState=newStatusState;
        printStatus();
    }

    public void previousState() {
        currentState.prev();
    }

    public void nextState() {
        currentState.next();
    }

    public void printStatus() {
        currentState.printStatus();
    }

    public statusState getCurrentState(){
        return currentState;
    }

}
