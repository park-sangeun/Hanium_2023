package com.idLogin.idLogin.entity;

import com.idLogin.idLogin.dto.MDataDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "m_robot_info")
public class MDataEntity {

    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long mrobotinfoid;

    @Column
    @NotNull
    private Float m_humidity;

    @Column
    @NotNull
    private Float m_temp;


    public static MDataEntity toMDataEntity(MDataDTO mdataDTO) {
        MDataEntity mdataEntity = new MDataEntity();
        mdataEntity.setM_humidity(mdataDTO.getM_humidity());
        mdataEntity.setM_temp(mdataDTO.getM_temp());
        return mdataEntity;
    }

}
