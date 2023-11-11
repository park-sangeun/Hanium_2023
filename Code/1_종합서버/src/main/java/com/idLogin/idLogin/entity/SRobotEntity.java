package com.idLogin.idLogin.entity;

import com.idLogin.idLogin.dto.MRobotDTO;
import com.idLogin.idLogin.dto.SRobotDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@Setter
@Getter
@Table(name = "sRobot")
public class SRobotEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long sRobot_id;

    @JoinColumn(name="container_time")
    @DateTimeFormat
    private Timestamp s_startTime;

    @Column
    @NotNull
    private Integer s_battery;

    public static SRobotEntity toSRobotEntity(SRobotDTO srobotDTO) {
        SRobotEntity srobotEntity = new SRobotEntity();
        srobotEntity.setS_startTime(srobotDTO.getS_startTime());
        srobotEntity.setS_battery(srobotDTO.getS_battery());
        return srobotEntity;
    }

    public static SRobotEntity toupdateSRobotEntity(SRobotDTO srobotDTO) {
        SRobotEntity srobotEntity = new SRobotEntity();
        srobotEntity.setSRobot_id(srobotDTO.getSRobot_id());
        srobotEntity.setS_startTime(srobotDTO.getS_startTime());
        srobotEntity.setS_battery(srobotDTO.getS_battery());
        return srobotEntity;
    }
}
