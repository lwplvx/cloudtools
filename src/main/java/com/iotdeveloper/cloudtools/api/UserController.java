package com.iotdeveloper.cloudtools.api;

import com.iotdeveloper.cloudtools.model.Response.AbstractJsonResponse;
import com.iotdeveloper.cloudtools.model.Response.UnrealizedResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public AbstractJsonResponse get()
    {
        return  new UnrealizedResponse("users get");
    }

    @RequestMapping(value = "/users/{userName}",method = RequestMethod.GET)
    public AbstractJsonResponse getByUserName(@PathVariable("userName") String userName)
    {
        return  new UnrealizedResponse("users/{userName} get");
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public AbstractJsonResponse post()
    {
        return  new UnrealizedResponse("users post");
    }

    @RequestMapping(value = "/users/login",method = RequestMethod.POST)
    public AbstractJsonResponse login()
    {
        return  new UnrealizedResponse("users login");
    }
}
