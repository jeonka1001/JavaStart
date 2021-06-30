package com.surveypro.member.service;

import com.surveypro.member.dao.MemberDAO;
import com.surveypro.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberChangePasswordService")
public class MemberChangePasswordServiceImpl implements MemberChangePasswordService {

    @Autowired
    MemberDAO dao;

    @Override
    public void doService(MemberVO member){
        dao.update(member);
    }
}
