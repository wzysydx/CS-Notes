package BIOModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类注释
 *
 * @Auther: 王中一
 * @Date: 2021/03/13/1:13
 * @Description:
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1. 定义一个servletSocket对象注册
            ServerSocket ss = null;
            ss = new ServerSocket(9999);
            //2.监听客户端的Socker请求
            Socket socket = ss.accept();
            //3.
            InputStream is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
