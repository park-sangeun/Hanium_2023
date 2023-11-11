package com.idLogin.idLogin.repository;

import com.idLogin.idLogin.entity.SDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface SDataRepository extends JpaRepository<SDataEntity, Long> {
    List<SDataEntity> findTop7ByOrderBySrobotinfoidAsc();

    List<SDataEntity> findTop7ByOrderBySrobotinfoidDesc();
}
