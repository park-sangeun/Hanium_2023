package com.idLogin.idLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LiveController {
    @CrossOrigin(origins = "http://localhost:8080") // 허용할 origin을 지정
    @GetMapping("/disaster")
    public String liveform(){
        return "disaster";
    }
    @GetMapping("location")
    public String locationform(){
        return "location";
    }
}
