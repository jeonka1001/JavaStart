package com.surveypro.member.dao;

import com.surveypro.member.exception.MemberException;
import com.surveypro.member.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
    void insert(MemberVO member)throws MemberException;
    boolean find(String column, String value)throws MemberException;
    MemberVO login(String email, String password);
    void update(MemberVO member);
}
