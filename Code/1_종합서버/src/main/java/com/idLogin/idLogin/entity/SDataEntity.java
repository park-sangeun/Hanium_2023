package com.idLogin.idLogin.entity;

import com.idLogin.idLogin.dto.SDataDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "s_robot_info")
public class SDataEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long srobotinfoid;

    @Column
    @NotNull
    private Float s_humidity;

    @Column
    @NotNull
    private Float s_temp;


    public static SDataEntity toSDataEntity(SDataDTO sdataDTO) {
        SDataEntity sdataEntity = new SDataEntity();
        sdataEntity.setS_humidity(sdataDTO.getS_humidity());
        sdataEntity.setS_temp(sdataDTO.getS_temp());
        return sdataEntity;
    }

}
