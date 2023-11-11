package com.idLogin.idLogin.dto;

import com.idLogin.idLogin.entity.MDataEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MDataDTO {
    private Long mrobotinfoid; // 필드명을 카멜 케이스로 변경
    private Float m_humidity;
    private Float m_temp;

    // toMDataDto 메서드를 toMDataEntity로 수정
    public static MDataDTO toMDataDto(MDataEntity mdataEntity) {
        MDataDTO mdataDTO = new MDataDTO();
        mdataDTO.setMrobotinfoid(mdataEntity.getMrobotinfoid());
        mdataDTO.setM_humidity(mdataEntity.getM_humidity());
        mdataDTO.setM_temp(mdataEntity.getM_temp());
        return mdataDTO;
    }
}
