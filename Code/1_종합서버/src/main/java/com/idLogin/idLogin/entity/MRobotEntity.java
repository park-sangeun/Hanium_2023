package com.idLogin.idLogin.entity;

import com.idLogin.idLogin.dto.MRobotDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "mRobot")
public class MRobotEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long mRobot_id;

    @Column
    @CreationTimestamp
    private Timestamp m_startTime;

    @Column
    @CreationTimestamp
    private Timestamp container_time;

    @Column
    @NotNull
    private Integer servo_container;

    @Column
    @NotNull
    private Integer m_battery;

    public static MRobotEntity toMRobotEntity(MRobotDTO mrobotDTO) {
        MRobotEntity mrobotEntity = new MRobotEntity();
        mrobotEntity.setM_startTime(mrobotDTO.getM_startTime());
        mrobotEntity.setContainer_time(mrobotDTO.getContainer_time());
        mrobotEntity.setServo_container(mrobotDTO.getServo_container());
        mrobotEntity.setM_battery(mrobotDTO.getM_battery());
        return mrobotEntity;
    }

    public static MRobotEntity toupdateMRobotEntity(MRobotDTO mrobotDTO) {
        MRobotEntity mrobotEntity = new MRobotEntity();
        mrobotEntity.setMRobot_id(mrobotDTO.getMRobot_id());
        mrobotEntity.setM_startTime(mrobotDTO.getM_startTime());
        mrobotEntity.setContainer_time(mrobotDTO.getContainer_time());
        mrobotEntity.setServo_container(mrobotDTO.getServo_container());
        mrobotEntity.setM_battery(mrobotDTO.getM_battery());
        return mrobotEntity;
    }

}
