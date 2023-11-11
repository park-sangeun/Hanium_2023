package com.idLogin.idLogin.service;

import com.idLogin.idLogin.dto.MDataDTO;
import com.idLogin.idLogin.dto.SDataDTO;
import com.idLogin.idLogin.entity.MDataEntity;
import com.idLogin.idLogin.entity.SDataEntity;
import com.idLogin.idLogin.repository.MDataRepository;
import com.idLogin.idLogin.repository.SDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {
    private final MDataRepository mDataRepository;
    private final SDataRepository sDataRepository;

    @Autowired
    public DataService(MDataRepository mDataRepository, SDataRepository sDataRepository) {
        this.mDataRepository = mDataRepository;
        this.sDataRepository = sDataRepository;
    }

    public List<MDataDTO> getLatestTemperatureHumidityData() {
        List<MDataEntity> mDataEntities = mDataRepository.findTop7ByOrderByMrobotinfoidDesc();
        List<MDataDTO> reversedData = mDataEntities.stream()
                .map(MDataDTO::toMDataDto)
                .collect(Collectors.toList());

        Collections.reverse(reversedData); // 역순으로 배열

        return reversedData;
    }

    public List<SDataDTO> getLatestTemperatureHumidity() {
        List<SDataEntity> sDataEntities = sDataRepository.findTop7ByOrderBySrobotinfoidDesc();
        List<SDataDTO> reversedData = sDataEntities.stream()
                .map(SDataDTO::toSDataDto)
                .collect(Collectors.toList());

        Collections.reverse(reversedData); // 역순으로 배열

        return reversedData;
    }
}



