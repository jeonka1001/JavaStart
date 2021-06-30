package com.surveypro.member.service;

import com.surveypro.member.dao.MemberDAO;
import com.surveypro.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberLoginService")
public class MemberLoginServiceImpl implements MemberLoginService{

    @Autowired
    private MemberDAO dao;

    @Override
    public MemberVO doService(String email, String password){
        return dao.login(email,password);
    }

}
