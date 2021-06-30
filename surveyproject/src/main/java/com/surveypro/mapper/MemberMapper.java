package com.surveypro.mapper;

import com.surveypro.member.exception.MemberException;
import com.surveypro.member.vo.MemberVO;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    void insert(MemberVO member)throws MemberException;
    String find(@Param("column")String column, @Param("value")String value)throws MemberException;
    MemberVO login(@Param("email")String email, @Param("password") String password);
    void update(MemberVO member);
}
