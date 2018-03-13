package com.iotdeveloper.cloudtools.model.ws;

public enum MessageTypes {

    onDeleteListening("onDeleteListening",0x01),
    onListening("onListening",0x02),
    onConnected("onConnected",0x03),
    onData("onData",0x04),
    onClose("onClose",0x05),
    info("info",0x06),

    //  0x01-- 0x1f   预留

    //  0x20-- 0x3f   预留 给
    event_join("event_join",0x20),

    // 0x40-- 0x4f   预留 给   port 相关
    onTcpPort("onTcpPort",0x40),
    onUdpPort("onUdpPort",0x41),

    // 0x50-- 0x5f   预留 给  用户权限相关
    onCreateLimit("onCreateLimit",0x51),
    onConnectionLimit("onConnectionLimit",0x51),

    //  0xe0-- 0xff   预留 给错误信息
    error("error",0xff);

    private String name;
    private int value;

    MessageTypes(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (MessageTypes m : MessageTypes.values()) {
            if (m.getValue() == value) {
                return m.name;
            }
        }
        return null;
    }
    // get set 方法

    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }




}

