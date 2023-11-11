package com.idLogin.idLogin.dto;

import com.idLogin.idLogin.entity.MDataEntity;
import com.idLogin.idLogin.entity.SDataEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SDataDTO {
    private Long srobotinfoid;
    private Float s_humidity;
    private Float s_temp;

    public static SDataDTO toSDataDto(SDataEntity sdataEntity) {
        SDataDTO sdataDTO = new SDataDTO();
        sdataDTO.setSrobotinfoid(sdataEntity.getSrobotinfoid());
        sdataDTO.setS_humidity(sdataEntity.getS_humidity());
        sdataDTO.setS_temp(sdataEntity.getS_temp());
        return sdataDTO;
    }

}
