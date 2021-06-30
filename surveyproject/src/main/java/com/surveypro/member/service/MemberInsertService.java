package com.surveypro.member.service;

import com.surveypro.member.vo.MemberVO;

import javax.servlet.http.HttpServlet;

public interface MemberInsertService {
    void doService(MemberVO member);
}
