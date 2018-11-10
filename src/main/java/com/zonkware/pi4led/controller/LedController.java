package com.zonkware.pi4led.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    private static GpioPinDigitalOutput redPin, greenPin;

    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }

    @RequestMapping("/red")
    public String redLight() {
        if (redPin == null) {
            GpioController gpio = GpioFactory.getInstance();
            redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "red", PinState.LOW);
        }

        redPin.toggle();

        return "Red LED toggled";
    }

    @RequestMapping("/green")
    public String greenLight() {
        if (greenPin == null) {
            GpioController gpio = GpioFactory.getInstance();
            greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "green", PinState.LOW);
        }

        greenPin.toggle();

        return "Green LED toggled";
    }

}
