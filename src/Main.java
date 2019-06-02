public class Main {

    public static void main(String[] args) {
        User user =new User(123);
        DownloadSystem ds= new DownloadSystem(user);
        ds.turnOn();
        ds.internet.turnOn();
        File f1 = new File(1,15);
        File f2 = new File(2,90);
        File f3 = new File(3,15);
        File f4 = new File(4,15);
        File f5 = new File(4,15);
        ds.addNewFile(f1);
        ds.addNewFile(f2);
        ds.addNewFile(f3);
        //ds.internet.turnOff();
        //ds.internet.turnOn();
        ds.addNewFile(f4);
        ds.addNewFile(f5);
        ds.fileRequest();
        ds.fileRequest();
        ds.fileRequest();
        ds.fileRequest();
        ds.fileRequest();
    }
}
