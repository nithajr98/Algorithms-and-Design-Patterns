package concurrency;

public class TmpThread extends Thread{
     int number;
    TmpThread(int number){
        this.number=number;
    }
    @Override
    public void run() {
        System.out.println("running tmpThread :"+number);
    }
}
