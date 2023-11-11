package com.idLogin.idLogin.dto;

import com.idLogin.idLogin.entity.SRobotEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SRobotDTO {
    private Long sRobot_id;
    private Timestamp s_startTime;
    private Integer s_battery;

    public static SRobotDTO tosrobotDTO(SRobotEntity srobotEntity) {
        SRobotDTO srobotDTO = new SRobotDTO();
        srobotDTO.setSRobot_id(srobotEntity.getSRobot_id());
        srobotDTO.setS_startTime(srobotEntity.getS_startTime());
        srobotDTO.setS_battery(srobotEntity.getS_battery());
        return srobotDTO;
    }

}
