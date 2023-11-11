package com.idLogin.idLogin.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilesDTO {
    private Long fno;
    private String filename;
    private String fileUrl;
    private Date uploadDate;

    // 매개변수를 받아 초기화하는 생성자

    // 생성자, getter, setter 등 필요한 메서드를 추가할 수 있음

}
