package com.iotdeveloper.cloudtools.controller;

import com.iotdeveloper.cloudtools.ws.WsMessage;
import com.iotdeveloper.cloudtools.ws.WsResponse;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WsController {

    @RequestMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WsResponse say(WsMessage message)
    {
        return new WsResponse("Welcome"+message.getName());
    }
}
