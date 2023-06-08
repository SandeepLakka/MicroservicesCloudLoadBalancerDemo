package com.test.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    private final HelloService helloService;
    private final String instance;
    public HelloController(HelloService helloService, @Value("${eureka.instance.instance-id}") String instance) {
        this.helloService = helloService;
        this.instance = instance;
    }

    @GetMapping("/increment")
    public String increment(){
        long newValue = helloService.increment();
        return String.format("Counter incremented : Current value = %d - Instance : %s",
                newValue, instance);
    }

    @GetMapping("/decrement")
    public String decrement(){
        long newValue = helloService.decrement();
        return String.format("Counter decremented : Current value = %d - Instance : %s",
                newValue, instance);
    }

    @GetMapping("/hello")
    public String getHelloWordObject() {
        return String.format("Hi there! Current number %d - Instance : %s", helloService.getCounterValue(), instance);
    }
}