public class InternetConnection {
    boolean active=false;

    public InternetConnection(){

    }

    public void turnOn (){
        if (!active)
            System.out.println("exit InternetOff");
        active=true;
        System.out.println("enter InternetON");
    }

    public void turnOff (){
        if (active)
            System.out.println("exit InternetON");
        active=false;
        System.out.println("enter InternetOff");
    }


}
