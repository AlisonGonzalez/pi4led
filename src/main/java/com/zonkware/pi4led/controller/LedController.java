package com.zonkware.pi4led.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    private static GpioPinDigitalOutput redPin, greenPin, yellowPin;
    private GpioController gpio = GpioFactory.getInstance();

    @RequestMapping("/")
    public String greeting() {
        return "Hello world!";
    }

    @RequestMapping("/red")
    public String redLight() {
        if (redPin == null) {
            redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "red", PinState.LOW);
        }

        redPin.toggle();

        return "Red LED toggled";
    }

    @RequestMapping("/green")
    public String greenLight() {
        if (greenPin == null) {
            greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "green", PinState.LOW);
        }

        greenPin.toggle();

        return "Green LED toggled";
    }

    @RequestMapping("/yellow")
    public String yellowLight() {
        if (yellowPin == null) {
            yellowPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "yellow", PinState.LOW);
        }

        yellowPin.toggle();

        return "Yellow LED toggled";
    }

}
