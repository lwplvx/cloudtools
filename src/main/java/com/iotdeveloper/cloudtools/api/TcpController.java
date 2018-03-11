package com.iotdeveloper.cloudtools.api;

import com.iotdeveloper.cloudtools.model.UdpSocket;
import com.iotdeveloper.cloudtools.service.UDPService;
import com.iotdeveloper.cloudtools.setting.ToolsSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TcpController {

    @Autowired
    private ToolsSettings toolsSettings;


    /**
     * @return
     */
    @RequestMapping(value = "/tcp", method = RequestMethod.POST)
    public Object post()
    {

        return "post";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/tcp", method = RequestMethod.GET)
    public Object get()
    {
        return "post";
    }

    /**
     * @param port
     * @return
     */
    @RequestMapping(value = "/tcp/{port}", method = RequestMethod.GET)
    public Object get(@PathVariable("port") int port)
    {
        return "post "+ port                ;
    }


    @RequestMapping("/send")
    String send() {

        UdpSocket udpSocket = UDPService.getInstance().findUdpSocket(toolsSettings.getUdpPort());

        if (udpSocket != null) {
            udpSocket.send("23.97.75.9",9001,"hi,iot-developer");
            udpSocket.send("127.0.0.1",49551,"hi,iot-developer");

            return "发送成功";
        }

        return "发送 udpSocket==null ";
    }

}
