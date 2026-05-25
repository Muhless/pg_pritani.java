package com.example.pg_pritani;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
     @GetMapping("/hello")
     public MessageResponse hello() {
          return new MessageResponse("cihuy");
     }
}
