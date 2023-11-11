package com.idLogin.idLogin.controller;

import com.idLogin.idLogin.dto.FilesDTO;
import com.idLogin.idLogin.entity.Files;
import com.idLogin.idLogin.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService filesService;

    @GetMapping("/insert")
    public String insert() {
        return "insert";
    }

    @PostMapping("/fileinsert")
    public String fileinsert(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception {
        String sourceFileName = files.getOriginalFilename();
        // 소문자로 확장자 추출
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();

        // MIME 타입 확인
        String contentType = files.getContentType();
        System.out.println("MIME 타입: " + contentType);

        File destinationFile;
        String destinationFileName;
        String fileUrl = "C:\\Users\\박상은\\Desktop\\idLogin2\\idLogin2\\idLogin\\idLogin\\src\\main\\resources\\static\\videos";

        do {
            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
            destinationFile = new File(fileUrl + destinationFileName);
        } while (destinationFile.exists());

        destinationFile.getParentFile().mkdirs();
        files.transferTo(destinationFile);

        Files file = new Files();
        // 파일 메타데이터 설정
        file.setFilename(destinationFileName);
        file.setFileOriName(sourceFileName);
        file.setFileUrl(fileUrl);
        file.setUploadDate(new Date());

        // 파일을 데이터베이스에 저장하고 저장된 파일의 고유 식별자를 얻음
        Long fileId = filesService.save(file);

        return "redirect:/video/insert";
    }

    @GetMapping("/")
    public String videoAll(Model model) {
        List<Files> filesList = filesService.videoAll();

        // 엔티티를 DTO로 변환하여 리스트에 담기
        List<FilesDTO> fileDTOList = filesList.stream()
                .map(file -> new FilesDTO(file.getFno(), file.getFilename(), file.getFileUrl(), file.getUploadDate()))
                .collect(Collectors.toList());

        // DTO 리스트를 모델에 추가하여 화면으로 전달
        model.addAttribute("filesList", fileDTOList);
        return "videodata"; // videodata.html을 렌더링하여 보여줌
    }

    @CrossOrigin(origins = "http://localhost:8080") // 클라이언트 도메인 추가
    @GetMapping("/getFilesList")
    @ResponseBody
    public ResponseEntity<List<FilesDTO>> getFilesList() {
        List<Files> filesList = filesService.videoAll();

        List<FilesDTO> videoFilesList = filesList.stream()
                .map(file -> new FilesDTO(file.getFno(), file.getFilename(), file.getFileUrl(), file.getUploadDate())) // 파일 URL 추가
                .collect(Collectors.toList());

        return new ResponseEntity<>(videoFilesList, HttpStatus.OK);
    }

    @GetMapping("/play")
    public ResponseEntity<Resource> playVideo(@RequestParam("fileId") Long fileId) {
        Files file = filesService.findByFno(fileId);

        if (file == null) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = filesService.loadFileAsResource(file.getFileUrl() + file.getFilename());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/videoview")
    public String showVideoView(@RequestParam("fileId") Long fileId, Model model) {
        // fileId를 모델에 추가하여 videoview.html로 전달
        model.addAttribute("fileId", fileId);
        return "videoview"; // videoview.html을 렌더링하여 보여줌
    }
    @PostMapping("/error")
    public String errorform() {
        return "error"; // error.html을 렌더링하여 보여줌
    }
}

