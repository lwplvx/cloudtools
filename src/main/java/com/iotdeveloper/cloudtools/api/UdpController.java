package com.iotdeveloper.cloudtools.api;

import com.iotdeveloper.cloudtools.model.Response.AbstractJsonResponse;
import com.iotdeveloper.cloudtools.model.Response.ErrorResponse;
import com.iotdeveloper.cloudtools.model.Response.UnrealizedResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lwplvx on 2018/3/12.
 */
@RestController
public class UdpController
{

    /**
     * @return
     */
    @RequestMapping(value = "/udp", method = RequestMethod.POST)
    public AbstractJsonResponse post() {

        return new ErrorResponse("post 未实现");
    }

    /**
     * @return
     */
    @RequestMapping(value = "/udp", method = RequestMethod.GET)
    public AbstractJsonResponse get() {


        return  new UnrealizedResponse("udp get");
    }

    /**
     * @param port
     * @return
     */
    @RequestMapping(value = "/udp/{port}", method = RequestMethod.GET)
    public AbstractJsonResponse getByPort(@PathVariable("port") int port) {


        return  new UnrealizedResponse("tcp/{port} get");
    }


}
