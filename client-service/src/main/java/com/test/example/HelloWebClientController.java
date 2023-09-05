package com.test.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class HelloWebClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String handleRequest() {
        //accessing hello-service
        String response = null;
        try {
            log.info("API-CALL : Calling /");
            response = restTemplate.getForObject("http://api.example.com/resource", String.class);
            log.info("API-CALL : CALLED API : Response : {}", response);

        }catch (IllegalStateException ise){
            log.error("Exception occured while making API call : {}", ise.getMessage());
        }
        return response;
    }


}
