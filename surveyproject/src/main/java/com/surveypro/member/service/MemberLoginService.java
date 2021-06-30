package com.surveypro.member.service;

import com.surveypro.member.vo.MemberVO;

public interface MemberLoginService {
    MemberVO doService(String email, String password);
}
