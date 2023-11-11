package com.idLogin.idLogin.entity;

import com.idLogin.idLogin.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "user")
public class MemberEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long user_no;

    @Column(name = "userId", unique = true)
    @NotNull
    private String userId;

    @Column
    @NotNull
    private String user_password;

    @Column
    @NotNull
    private String name;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId(memberDTO.getUserId());
        memberEntity.setUser_password(memberDTO.getUser_password());
        memberEntity.setName(memberDTO.getName());
        return memberEntity;
    }

    public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUser_no(memberDTO.getUser_no());
        memberEntity.setUserId(memberDTO.getUserId());
        memberEntity.setUser_password(memberDTO.getUser_password());
        memberEntity.setName(memberDTO.getName());
        return memberEntity;
    }

}
