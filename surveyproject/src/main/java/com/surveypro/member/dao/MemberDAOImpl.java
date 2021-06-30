package com.surveypro.member.dao;

import com.surveypro.mapper.MemberMapper;
import com.surveypro.member.exception.MemberException;
import com.surveypro.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    private MemberMapper mapper;

    @Override
    public void insert(MemberVO member)throws MemberException{
        mapper.insert(member);
    }

    @Override
    public boolean find(String column, String value)throws MemberException{
        String res = mapper.find(column,value);
        return res == null;
    }
    @Override
    public MemberVO login(String email, String password){
        return mapper.login(email,password);
    }
    @Override
    public void update(MemberVO member){
        System.out.println("dao()");
        mapper.update(member);
    }
}
