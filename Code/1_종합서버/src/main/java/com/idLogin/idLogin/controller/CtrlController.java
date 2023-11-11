package com.idLogin.idLogin.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CtrlController {
    @MessageMapping("/controlMotor")
    @SendTo("/topic/motorStatus")
    public String controlMotor(String message) {
        // 여기에서 라즈베리 파이로 신호를 전달하고 모터를 제어합니다.
        // message를 분석하여 모터 동작을 결정하고 제어합니다.
        String motorStatus = "모터 동작 중: " + message;
        return motorStatus;
    }

    @GetMapping("/controller")
    public String controlform() {
        return "controller";
    }
}
