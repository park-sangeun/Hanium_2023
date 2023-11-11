package com.idLogin.idLogin.repository;

import com.idLogin.idLogin.entity.SRobotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SRobotRepository extends JpaRepository<SRobotEntity, Long> {
    @Query("SELECT s FROM SRobotEntity s")
    List<SRobotEntity> prints2();
}
