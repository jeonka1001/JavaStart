package com.surveypro.member.service;

import com.surveypro.member.vo.MemberVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service("memberLoginCheckService")
public class MemberLoginCheckServiceImpl implements MemberLoginCheckService{

    @Override
    public boolean doService(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        return session.getAttribute("result") != null;
    }
}
