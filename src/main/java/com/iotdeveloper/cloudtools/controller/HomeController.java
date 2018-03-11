package com.iotdeveloper.cloudtools.controller;

import com.iotdeveloper.cloudtools.service.TCPService;
import com.iotdeveloper.cloudtools.service.UDPService;
import com.iotdeveloper.cloudtools.setting.ToolsSettings;
import com.iotdeveloper.cloudtools.ws.WsMessage;
import com.iotdeveloper.cloudtools.ws.WsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @Autowired
    private ToolsSettings toolsSettings;

    StringBuffer str = new StringBuffer("Hello Spring Boot !");

    //ModelAndView

    /**
     * @return
     */
    @RequestMapping("/")
    public ModelAndView index() {
        str.delete(0, str.length());
        str.append(" Hello Spring Boot !");
        str.append(" Address:");
        str.append(toolsSettings.getAddress());

        str.append(" Address:");
        str.append(toolsSettings.getAddress());

        str.append(" udpPort:");
        str.append(toolsSettings.getUdpPort());
        str.append("-");
        str.append(toolsSettings.getUdpPort() + toolsSettings.getPortNumber());

        str.append(" tcpPort:");
        str.append(toolsSettings.getTcpPort());
        str.append("-");
        str.append(toolsSettings.getTcpPort() + toolsSettings.getPortNumber());

        UDPService.getInstance().createUdpServer(toolsSettings.getUdpPort());
        TCPService.getInstance().createTCPService(toolsSettings.getTcpPort());

        //return "index";
        ModelAndView result = new ModelAndView("index");
        result.addObject("message",str.toString());
        return result;// View("projects/index", "projectList", projectList);
    }


}
