package JMM;

import java.util.concurrent.TimeUnit;

/**
 * 类注释
 *
 * @Auther: 王中一
 * @Date: 2021/03/14/12:51
 * @Description:
 */
public class JMMDemo {
    // volatile不加的话会死循环
    private static volatile int num = 0;

    public static void main(String[] args) {


        new Thread(()-> {
            while (num==0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);
    }
}
