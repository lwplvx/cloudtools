package com.iotdeveloper.cloudtools.service;

import com.iotdeveloper.cloudtools.model.TcpServer;

import java.util.HashMap;
import java.util.Map;

public class TCPService {
    private Map<Integer, TcpServer> tcpMap = new HashMap<>();

    private TCPService() {
    }

    private static TCPService _instance;

    public static TCPService getInstance() {
        if (_instance == null) {
            _instance = new TCPService();
        }
        return _instance;
    }

    public boolean createTCPService(int port) {
        TcpServer tcpServer = createTcpServer(port);
        return tcpServer != null;
    }

    private TcpServer createTcpServer(int port) {
        TcpServer tcpServer = findTcpServer(port);
        if (tcpServer == null) {
            tcpServer = new TcpServer(port);
            tcpMap.put(port, tcpServer);
        }
        System.out.println("创建TCP " + tcpServer.getName());
        return tcpServer;
    }

    public TcpServer findTcpServer(int udpPort) {
        if (tcpMap.containsKey(udpPort)) {
            return tcpMap.get(udpPort);
        }
        return null;
    }

}
