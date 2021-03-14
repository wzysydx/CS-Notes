package JMM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile
 */
public class VDemo02 {

    //volatile不保证原子性
    private volatile static AtomicInteger num = new AtomicInteger(0);

    //synchronized保证原子性
    public synchronized static void add(){
        num.getAndIncrement(); // CAS
    }

    public static void main(String[] args) {

        //理论上为20000
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);

    }
}
