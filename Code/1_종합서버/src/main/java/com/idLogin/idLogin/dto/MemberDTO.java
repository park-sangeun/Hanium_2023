package com.idLogin.idLogin.dto;

import com.idLogin.idLogin.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long user_no;
    private String userId;
    private String user_password;
    private String name;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUser_no(memberEntity.getUser_no());
        memberDTO.setUserId(memberEntity.getUserId());
        memberDTO.setUser_password(memberEntity.getUser_password());
        memberDTO.setName(memberEntity.getName());
        return memberDTO;
    }
}
