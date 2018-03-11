package com.iotdeveloper.cloudtools.model;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiveDemo {

    public void demo() {
        DatagramSocket socket = null;

        try {

            socket = new DatagramSocket(12345);// 建立基站
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf
                    , buf.length);//建立机房

            socket.receive(packet);// 开始接受数据

            //获取对方的主机信息
            InetAddress address = packet.getAddress();

            System.out.println(address.getHostAddress());
            //获取数据内容
            byte[] data = packet.getData();
            System.out.println("数据内容:" + new String(data, 0, packet.getLength()));
            //获取对方数据长度
            int length = packet.getLength();
            System.out.println("数据长度：" + length);

            //获取接收端口号
            int port = packet.getPort();
            System.out.println("接收端口号是：" + port);


        } catch (Exception e) {
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }

}
