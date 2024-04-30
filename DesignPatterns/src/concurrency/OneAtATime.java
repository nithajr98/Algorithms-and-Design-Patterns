package concurrency;

public class OneAtATime {
    static Integer t= 0;
    synchronized void increase()  {
        t++;
    }
    synchronized void decrease(){
        t--;
    }

    public static void main(String[] args) throws InterruptedException {
        OneAtATime one = new OneAtATime();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (one){
                    for(int i=0;i<10;i++){
                        t++;
                        System.out.println(t);
                    }
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (one){
                    for(int i=0;i<10;i++){
                        t--;
                        System.out.println(t);
                    }
                }

            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (one){
                    for(int i=0;i<5;i++){
                        t=t*10;
                        System.out.println(t);
                    }
                }

            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(t);
    }
}
