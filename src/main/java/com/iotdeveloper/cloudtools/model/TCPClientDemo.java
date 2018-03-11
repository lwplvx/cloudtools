package com.iotdeveloper.cloudtools.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPClientDemo {


    public void demo() {
        Socket socket = null;
        InputStream inputStream = null;

        try {

            //建立基站获取链接地址及端口号
            socket = new Socket("localhost", 8899);
            //获取服务器发过来的字节流
            inputStream = socket.getInputStream();

            //开始解析字节流
            byte[] b = new byte[1024];
            String str = "";
            int length = -1;
            while ((length = inputStream.read(b, 0, b.length)) != -1) {
                str += new String(b, 0, length);
            }
            System.out.println(str);
             /*
              * int length = inputStream.read(b);
              System.out.println(new String(b, 0, length));
              */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //最后关闭
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }

        }

    }


}
