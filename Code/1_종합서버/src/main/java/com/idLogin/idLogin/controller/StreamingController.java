package com.idLogin.idLogin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class StreamingController {
    @GetMapping("/st")
    public RedirectView redirectToExternalURL() {
        String externalUrl = "http://172.20.10.7:8000/streaming";
        return new RedirectView(externalUrl);
    }

    @GetMapping("/streaming")
    public String st() {
        return "streaming"; // "streaming" 뷰 페이지를 반환
    }
}
