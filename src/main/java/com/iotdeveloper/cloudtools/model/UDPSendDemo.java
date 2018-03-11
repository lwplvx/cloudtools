package com.iotdeveloper.cloudtools.model;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {

    public void Send() {
        DatagramSocket socket = null;
        try {
            //建立基站
            socket = new DatagramSocket();
            byte[] buf = "hello,UDP".getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            //建立仓库
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 12345);
            //发送数据
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭基站
            if (socket != null) {
                socket.close();
            }
        }

    }

}
