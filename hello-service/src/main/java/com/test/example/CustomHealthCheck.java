package com.test.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomHealthCheck {


    private final HelloService helloService;

    public CustomHealthCheck(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        long counterValue = helloService.getCounterValue();

        if(counterValue == 0){
            return ResponseEntity.ok("Active");
        }else{
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(String.format("%s runs in progress", counterValue));
        }
    }
}
