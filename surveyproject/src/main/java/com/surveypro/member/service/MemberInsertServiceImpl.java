package com.surveypro.member.service;

import com.surveypro.member.dao.MemberDAO;
import com.surveypro.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("memberInsertService")
public class MemberInsertServiceImpl implements MemberInsertService {

    @Autowired
    private MemberDAO dao;

    @Override
    @Transactional
    public void doService(MemberVO member){
        dao.insert(member);
    }
}
