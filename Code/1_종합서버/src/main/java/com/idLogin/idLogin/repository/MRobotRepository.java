package com.idLogin.idLogin.repository;

import com.idLogin.idLogin.entity.MRobotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MRobotRepository extends JpaRepository<MRobotEntity, Long> {
    @Query("SELECT m FROM MRobotEntity m")
    List<MRobotEntity> printm2();
}
