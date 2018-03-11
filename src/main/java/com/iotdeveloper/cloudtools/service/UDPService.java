package com.iotdeveloper.cloudtools.service;

import com.iotdeveloper.cloudtools.model.UdpSocket;

import java.util.HashMap;
import java.util.Map;

public class UDPService {

    private Map<Integer, UdpSocket> udpMap = new HashMap<>();

    private UDPService() {
    }

    private static UDPService _instance;

    public static UDPService getInstance() {
        if (_instance == null) {
            _instance = new UDPService();
        }
        return _instance;
    }

    public boolean createUdpServer(int port) {
        UdpSocket udpSocket = createUdpSocket(port);
        return udpSocket != null;
    }

    private UdpSocket createUdpSocket(int port) {
        UdpSocket udpSocket = findUdpSocket(port);
        if (udpSocket == null) {
            udpSocket = new UdpSocket(port);
            udpMap.put(port, udpSocket);
        }
        System.out.println("创建UDP " + udpSocket.getName());
        return udpSocket;
    }

    public UdpSocket findUdpSocket(int udpPort) {
        if (udpMap.containsKey(udpPort)) {
            return udpMap.get(udpPort);
        }
        return null;
    }
}
