package com.surveypro.member.vo;



import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class MemberVO {

    private String email;
    private String nickname;
    private String password;
    private Timestamp regdate;

    @Builder
    public MemberVO(String email, String nickname, String password, Timestamp regdate) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.regdate = regdate;
    }
}
