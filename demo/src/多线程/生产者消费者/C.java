package 多线程.生产者消费者;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类注释
 *
 * @Auther: 王中一
 * @Date: 2021/03/13/11:01
 * @Description:
 */
public class C {
    public static void main(String[] args) {

        new Thread(() -> {},"A").start();
        new Thread(() -> {},"B").start();
        new Thread(() -> {},"C").start();
    }
}

class Data3 {
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            // 业务，判断，执行，通知
            while (num != 1) {
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "A");
            //唤醒制定的人
            num = 2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "BBBBB");
            condition3.signal();
            num = 3;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            // 业务，判断，执行，通知
            while (num != 3) {
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "C");
            //唤醒制定的人
            num = 1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
