package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;

public interface MemberLoginCheckService {
    boolean doService(HttpServletRequest request);
}
