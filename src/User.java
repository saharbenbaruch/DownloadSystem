import Status.Status;

public class User {
    int userId;
    Status status;

    public User(int id){
        userId=id;
        status=new Status();

    }

    public int getUserId() {
        return userId;
    }

    public int getPoints() {
        return status.getPoints();
    }


    public Status getStatus() {
        return status;
    }
}
