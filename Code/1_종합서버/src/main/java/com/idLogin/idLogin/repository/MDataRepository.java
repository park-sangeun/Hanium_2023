package com.idLogin.idLogin.repository;

import com.idLogin.idLogin.entity.MDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface MDataRepository extends JpaRepository<MDataEntity, Long> {
    List<MDataEntity> findTop7ByOrderByMrobotinfoidDesc();
}
