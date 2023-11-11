package com.idLogin.idLogin.repository;

import com.idLogin.idLogin.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 아이디로 회원 정보 조회 (select * from data_ex where user_id=?)
    Optional<MemberEntity> findByUserId(String user_id);

}
