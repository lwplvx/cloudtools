package com.iotdeveloper.cloudtools.api;

import com.iotdeveloper.cloudtools.model.Response.AbstractJsonResponse;
import com.iotdeveloper.cloudtools.model.Response.ErrorResponse;
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
    public AbstractJsonResponse post() {

        return new ErrorResponse("post 未实现");
    }

    /**
     * @return
     */
    @RequestMapping(value = "/tcp", method = RequestMethod.GET)
    public AbstractJsonResponse get() {


        return new ErrorResponse("get 未实现");
    }

    /**
     * @param port
     * @return
     */
    @RequestMapping(value = "/tcp/{port}", method = RequestMethod.GET)
    public AbstractJsonResponse get(@PathVariable("port") int port) {


        return new ErrorResponse("get tcp/{port} 未实现");
    }


    @RequestMapping("/send")
    public String send() {

        UdpSocket udpSocket = UDPService.getInstance().findUdpSocket(toolsSettings.getUdpPort());

        if (udpSocket != null) {
            udpSocket.send("23.97.75.9", 9001, "hi,iot-developer");
            udpSocket.send("127.0.0.1", 49551, "hi,iot-developer");

            return "发送成功";
        }

        return "发送 udpSocket==null ";
    }

}
