package com.iotdeveloper.cloudtools.model;

import com.iotdeveloper.cloudtools.net.IClientInfo;


public class RemoteInfo  implements IClientInfo{

    private byte[] data;
    private int length;
    private int port;
    private String address;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
