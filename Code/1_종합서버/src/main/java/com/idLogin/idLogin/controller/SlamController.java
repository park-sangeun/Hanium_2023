package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.entity.Slamdata;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SlamController {
    @MessageMapping("/lidar-data") // 클라이언트가 메시지를 보낼 엔드포인트
    @SendTo("/topic/lidar-data") // 클라이언트에게 메시지를 보낼 주제
    public Slamdata processLidarData(Slamdata slamdata) {
        // LidarData를 처리하고 클라이언트에게 반환
        return slamdata;
    }
}
