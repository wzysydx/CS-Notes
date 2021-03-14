package 多线程.八锁现象;

import java.util.concurrent.TimeUnit;

/**
 * 类注释
 *
 * @Auther: 王中一
 * @Date: 2021/03/13/11:18
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread( () -> {
            phone.sendSms();
        },"A").start();

        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread( () -> {
            phone.call();
        },"B").start();

    }
}

class Phone{
    public synchronized void sendSms(){
        System.out.println("sendSms");
    }

    public synchronized void call(){
        System.out.println("call");
    }
}
