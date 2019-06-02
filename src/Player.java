public class Player implements Observer{
    private boolean isLoadForPlay;
    private  boolean isPlay;

    public boolean isLoadForPlay() {
        return isLoadForPlay;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setLoadForPlay(boolean loadForPlay) {
        isLoadForPlay = loadForPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    public void movieOn(){
        if(isLoadForPlay){
            isPlay = true;
            System.out.println("Movie is On");
            //playing
            isPlay=false;
            System.out.println("Movie is Finished");
        }
        else System.out.println("Not 20% yet");
    }
    public void movieOff(){
        isPlay = false;
        System.out.println("Movie is Off");
    }

    public void holdMovie(){
        if(isPlay) {
            isPlay = false;
            System.out.println("Movie is Pause");
        }
    }


    public void resume(){
        if(!isPlay) {
            isPlay = false;
            System.out.println("Movie is resume");
        }
        //playing
        isPlay=false;
        System.out.println("Movie is Finished");
    }

    public void restartMovie(){
        if(!isPlay)
            System.out.println("Movie is Restarted");
        //playing
        isPlay=false;
        System.out.println("Movie is Finished");
    }

    @Override
    public void update(int change) {
        //0 = download reach to 20%
        if (change ==0 )
            isLoadForPlay=true;

        // 1 == download completed

        else if (change==1){
            isLoadForPlay=false;
            isPlay=false;
        }

    }
}