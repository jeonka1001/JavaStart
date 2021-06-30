package com.surveypro.member.service;

import com.surveypro.member.dao.MemberDAO;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service("memberCheckService")
public class MemberCheckServiceImpl implements MemberCheckService {

    @Autowired
    private MemberDAO dao;


    @Override
    public boolean doService(String column, String value){
        boolean res = dao.find(column,value);
        return res;
    }

}
