package com.iotdeveloper.cloudtools.model.ws;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTypesTest {

    @Test
    public void getName() {
        System.out.println(MessageTypes.getName(0xff));
        System.out.println(MessageTypes.error);
        System.out.println("error  getValue: "+ MessageTypes.error.getValue());
        System.out.println("error  ordinal: "+MessageTypes.error.ordinal());
        Assert.assertEquals(MessageTypes.getName(0xff),MessageTypes.error.toString());
    }

    @Test
    public void setName() {
    }

    @Test
    public void getValue() {
    }

    @Test
    public void setValue() {
    }

}