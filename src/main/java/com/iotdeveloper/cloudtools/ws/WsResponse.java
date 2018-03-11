package com.iotdeveloper.cloudtools.ws;

public class WsResponse {
    private String responseMessage;

    public  WsResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage() {
        return responseMessage;
    }

}
