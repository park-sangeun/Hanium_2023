package com.idLogin.idLogin.service;

import com.idLogin.idLogin.dto.MemberDTO;
import com.idLogin.idLogin.entity.MemberEntity;
import com.idLogin.idLogin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ComponentScan
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        try {
            // 1. dto -> entity 변환
            MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
            // 2. repository의 save 메서드 호출
            memberRepository.save(memberEntity);
        } catch (Exception e) {
            // 예외 발생 시 처리 로직
            e.printStackTrace(); // 콘솔에 오류 메시지 출력
            // 또는 로그를 기록하거나, 사용자에게 알림을 주는 등의 추가적인 처리
        }
    }

    public String login(String userId, String userPassword) {
        Optional<MemberEntity> byUser_id = memberRepository.findByUserId(userId);
        if (byUser_id.isPresent()) {
            MemberEntity memberEntity = byUser_id.get();
            if (memberEntity.getUser_password().equals(userPassword)) {
                return "success"; // 비밀번호 일치, 로그인 성공
            } else {
                return "fail"; // 비밀번호 불일치, 로그인 실패
            }
        } else {
            return "fail"; // 해당 아이디의 회원이 없음, 로그인 실패
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity: memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
//            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
//            memberDTOList.add(memberDTO);
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long user_no) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(user_no);
        if (optionalMemberEntity.isPresent()) {
//            MemberEntity memberEntity = optionalMemberEntity.get();
//            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
//            return memberDTO;
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }

    }

    public MemberDTO updateForm(String myId) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByUserId(myId);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }

    public void deleteById(Long user_no) {
        memberRepository.deleteById(user_no);
    }

    public String IdCheck(String userId) {
        Optional<MemberEntity> byUser_id = memberRepository.findByUserId(userId);
        if (byUser_id.isPresent()) {
            // 조회결과가 있다 -> 사용할 수 없다.
            return null;
        } else {
            // 조회결과가 없다 -> 사용할 수 있다.
            return "ok";
        }
    }
}
