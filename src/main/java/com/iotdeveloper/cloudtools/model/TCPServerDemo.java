package com.iotdeveloper.cloudtools.model;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {


    public void demo() {
        ServerSocket socket = null;
        OutputStream outputStream = null;

        try {
            //建立基站
            socket = new ServerSocket(8899);
            //开始开启接收模式,接到后返回客户端的socket对象
            Socket client = socket.accept();
            //获取向客户端发送消息的对象流
            outputStream = client.getOutputStream();
            //向客户端写数据
            outputStream.write("你连上了服务器...".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
