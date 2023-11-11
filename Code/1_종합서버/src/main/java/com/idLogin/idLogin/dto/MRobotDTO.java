package com.idLogin.idLogin.dto;

import com.idLogin.idLogin.entity.MRobotEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MRobotDTO {
    private Long mRobot_id;
    private Timestamp m_startTime;
    private Timestamp container_time;
    private Integer servo_container;
    private Integer m_battery;

    public static MRobotDTO tomrobotDTO(MRobotEntity mrobotEntity) {
        MRobotDTO mrobotDTO = new MRobotDTO();
        mrobotDTO.setMRobot_id(mrobotEntity.getMRobot_id());
        mrobotDTO.setM_startTime(mrobotEntity.getM_startTime());
        mrobotDTO.setContainer_time(mrobotEntity.getContainer_time());
        mrobotDTO.setServo_container(mrobotEntity.getServo_container());
        mrobotDTO.setM_battery(mrobotEntity.getM_battery());
        return mrobotDTO;
    }
}
