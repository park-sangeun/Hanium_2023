package com.idLogin.idLogin.service;

import com.idLogin.idLogin.dto.FilesDTO;
import com.idLogin.idLogin.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import com.idLogin.idLogin.entity.Files;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    VideoRepository filesRepository;

    // VideoService.java
    public Long save(Files files) {
        Files savedFile = filesRepository.save(files);
        return savedFile.getFno();
    }

    public Files findByFno(Long fno) {
        return filesRepository.findByFno(fno);
    }

    public List<Files> videoAll() {
        return filesRepository.findAll();
    }

    public List<FilesDTO> getAllFilesDTO() {
        List<FilesDTO> filesList = new ArrayList<>();

        // 파일 리스트를 데이터베이스에서 조회하는 로직
        List<Files> fileEntities = filesRepository.findAll(); // FileEntity는 실제 데이터베이스 테이블과 매핑되는 엔티티 클래스

        // FileEntity를 FileDTO로 변환하여 filesList에 추가하는 로직
        for (Files fileEntity : fileEntities) {
            FilesDTO fileDTO = new FilesDTO();
            fileDTO.setFno(fileEntity.getFno());
            fileDTO.setFilename(fileEntity.getFilename());
            fileDTO.setUploadDate(fileEntity.getUploadDate());
            filesList.add(fileDTO);
        }

        return filesList;
    }

    public Resource loadFileAsResource(String fileUrl) {
        try {
            // 파일 시스템 경로를 URL 형식으로 변환
            String urlPath = "file:" + fileUrl.replace("\\", "/");

            Resource resource = new UrlResource(urlPath);
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found: " + fileUrl);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found: " + fileUrl, ex);
        }
    }

    public Files getFileByFileUrl(String fileUrl) {
        return filesRepository.findByFileUrl(fileUrl);
    }
}
