package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.dto.MDataDTO;
import com.idLogin.idLogin.dto.SDataDTO;
import com.idLogin.idLogin.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @CrossOrigin(origins = "http://localhost:8080") // 허용할 origin을 지정
    @GetMapping("/mrobot")
    public String getDashboard(Model model) {
        List<MDataDTO> latestTemperatureHumidityData = dataService.getLatestTemperatureHumidityData();

        // 최신 온습도 데이터를 Thymeleaf 템플릿으로 전달
        model.addAttribute("latestTemperatureHumidityData", latestTemperatureHumidityData);

        return "robot"; // Thymeleaf 템플릿 이름
    }

    @GetMapping("/data/mrobotVal")
    @ResponseBody // 이 어노테이션을 추가하여 JSON 응답으로 변환
    public List<MDataDTO> getMRobotValData() {
        List<MDataDTO> latestTemperatureHumidityData = dataService.getLatestTemperatureHumidityData();
        return latestTemperatureHumidityData;
    }

    @CrossOrigin(origins = "http://localhost:8080") // 허용할 origin을 지정
    @GetMapping("/srobot")
    public String getsDashboard(Model model) {
        List<SDataDTO> latestTemperatureHumidity = dataService.getLatestTemperatureHumidity();

        // 최신 온습도 데이터를 Thymeleaf 템플릿으로 전달
        model.addAttribute("latestTemperatureHumidity", latestTemperatureHumidity);

        return "srobot"; // Thymeleaf 템플릿 이름
    }
    @GetMapping("/data/srobotVal")
    @ResponseBody // 이 어노테이션을 추가하여 JSON 응답으로 변환
    public List<SDataDTO> getSRobotValData() {
        List<SDataDTO> latestTemperatureHumidity = dataService.getLatestTemperatureHumidity();
        return latestTemperatureHumidity;
    }

}
