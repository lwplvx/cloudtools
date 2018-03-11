package com.iotdeveloper.cloudtools.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class TcpServer {
    private ServerSocket socket = null;
    private int port = 8500;

    // 首先创建一 个map集合
    private Map<String, Socket> clientMap = new HashMap<>();

    public TcpServer(int port) {
        this.port = port;
        init();
    }

    public String getName() {
        return "address " + this.port;
//     return socket.getInetAddress().toString()+":"+this.port;
    }

    private boolean init() {
        try {
            //建立基站
            socket = new ServerSocket(this.port);// 建立基站

            startAcceptClient();

        } catch (SocketException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void startAcceptClient() {
        new Thread(() -> {
            System.out.println("startAcceptClient,新的线程在执行...");
            while (socket != null) {
                try {
                    //开始开启接收模式,接到后返回客户端的socket对象
                    Socket client = socket.accept();

                    setClientInfo(client);

                    startReceiveData(client);
                    Thread.sleep(100);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    socket = null;
                }

            }
        }).start();
    }

    private void startReceiveData(Socket client) {
        new Thread(() -> {
            while (socket != null) {
                try {

                    //获取服务器发过来的字节流
                    InputStream inputStream = client.getInputStream();

                    //开始解析字节流
                    byte[] buf = new byte[1024];
                    String strReceive = "";
                    int length = -1;
                    while ((length = inputStream.read(buf, 0, buf.length)) != -1) {
                        strReceive += new String(buf, 0, length);
                    }
                    System.out.println("收到 client -> "+strReceive);

                    //获取向客户端发送消息的对象流
                    OutputStream outputStream = client.getOutputStream();
                    //向客户端写数据
                    outputStream.write("你连上了服务器...".getBytes());

                    Thread.sleep(100);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    socket = null;
                }

            }
        }).start();
    }

    private String createKey(Socket client) {

        return "tcpClient " + client.getInetAddress().getAddress() + ":" + client.getPort();
    }

    private void setClientInfo(Socket client) {
        String key = createKey(client);
        if (clientMap.containsKey(key)) {

        } else {
            clientMap.put(key, client);

            System.out.println(key+" 连上了服务器...");
        }
    }

}
