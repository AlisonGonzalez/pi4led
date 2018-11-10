package com.zonkware.pi4led.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {
    private GpioController gpio = GpioFactory.getInstance();
    private GpioPinDigitalOutput redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "red", PinState.LOW);
    private GpioPinDigitalOutput greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "green", PinState.LOW);
    private GpioPinDigitalOutput yellowPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "yellow", PinState.LOW);


    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }

    @RequestMapping("/red")
    public String redLight() {
        redPin.toggle();
        return "Red LED toggled";
    }

    @RequestMapping("/green")
    public String greenLight() {
        greenPin.toggle();
        return "Green LED toggled";
    }

    @RequestMapping("/yellow")
    public String yellowLight() {
        yellowPin.toggle();
        return "Yellow LED toggled";
    }

}
