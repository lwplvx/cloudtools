package com.iotdeveloper.cloudtools.model;

import com.iotdeveloper.cloudtools.utils.NetUtils;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class UdpSocket {
    private DatagramSocket socket = null;
    private int port = 9000;

    // 首先创建一 个map集合
    private Map<String, RemoteInfo> remoteInfoMap = new HashMap<>();

    public UdpSocket(int port) {
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
            socket = new DatagramSocket(this.port);// 建立基站

            startReceiveData();

        } catch (SocketException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void startReceiveData() {
        new Thread(() -> {
            System.out.println("startReceiveData,新的线程在执行...");
            while (socket != null) {
                try {
                    byte[] buf = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);//建立机房

                    socket.receive(packet);// 开始接收数据

                    RemoteInfo remoteInfo = setRemoteInfo(packet);

                    send(remoteInfo, " echo," + new String(remoteInfo.getData(), 0, remoteInfo.getLength()));

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

    private RemoteInfo setRemoteInfo(DatagramPacket packet) {
        String key = NetUtils.createUdpKey(packet);
        RemoteInfo remoteInfo;
        if (remoteInfoMap.containsKey(key)) {
            remoteInfo = remoteInfoMap.get(key);
        } else {
            remoteInfo = new RemoteInfo();
            remoteInfo.setAddress(packet.getAddress().toString());
            remoteInfo.setPort(packet.getPort());

            remoteInfoMap.put(key, remoteInfo);
        }

        remoteInfo.setData(packet.getData());
        remoteInfo.setLength(packet.getLength());

        System.out.println(key + " -> 数据内容:" + new String(remoteInfo.getData(), 0, remoteInfo.getLength()));
        return remoteInfo;
    }

    private boolean send(InetAddress address, int remotePort, byte[] buf) {

        try {
            //建立仓库
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, remotePort);
            //发送数据
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {

        }
        return true;
    }

    public boolean send(RemoteInfo remoteInfo, String msg) {

        byte[] buf = msg.getBytes();

        return send(remoteInfo.getAddress(), remoteInfo.getPort(), buf);

    }

    public boolean send(String remoteAddress, int remotePort, String msg) {

        byte[] buf = msg.getBytes();
        return send(remoteAddress,remotePort,buf);
    }

    public boolean send(String remoteAddress, int remotePort, byte[] buf )
    {
        try {
            return send(InetAddress.getByName(remoteAddress), remotePort, buf);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }
}
