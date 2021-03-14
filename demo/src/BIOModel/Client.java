package BIOModel;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 类注释
 *
 * @Auther: 王中一
 * @Date: 2021/03/13/1:13
 * @Description:
 */
public class Client {
    {
        try {
            //1.注册一个Socket
            Socket cs = new Socket("127.0.0.1", 9999);
            //2.创建输出流
            OutputStream os = cs.getOutputStream();
            //3.将字节输出宝成一个打印流
            PrintStream ps = new PrintStream(os);
            ps.println("服务端你好");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
