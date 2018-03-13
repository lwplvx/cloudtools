package com.iotdeveloper.cloudtools.controller;

import com.iotdeveloper.cloudtools.model.ws.WiselyMessage;
import com.iotdeveloper.cloudtools.model.ws.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome" + message.getName() + "!");
    }


    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) throws InterruptedException {

        if (principal.getName().equals("lwp")) {
            simpMessagingTemplate.convertAndSendToUser("zyp",
                    "/queue/notifications", principal.getName() + "-send");

        } else {
            simpMessagingTemplate.convertAndSendToUser("lwp",
                    "/queue/notifications", principal.getName() + "-send");
        }
    }

}
