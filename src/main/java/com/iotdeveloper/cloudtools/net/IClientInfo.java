package com.iotdeveloper.cloudtools.net;

import java.net.InetAddress;

public interface IClientInfo {

      int getPort();
      void setPort(int port);
      String getAddress();
      void setAddress(String address);
}
