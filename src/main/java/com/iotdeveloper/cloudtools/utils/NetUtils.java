package com.iotdeveloper.cloudtools.utils;

import java.net.DatagramPacket;
import java.net.Socket;

public class NetUtils {

    public static String createUdpKey(DatagramPacket packet) {

        return "udp "+packet.getAddress()+":"+packet.getPort();
    }

    public static String createTcpKey(Socket socket) {

        return "tcp "+socket.getInetAddress()+":"+socket.getPort();
    }
}
