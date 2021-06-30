package com.surveypro.member.controller;

import com.surveypro.member.service.*;
import com.surveypro.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;

@Controller
public class MemberController {

    @Autowired
    @Qualifier("memberInsertService")
    private MemberInsertService insertService ;

    @Autowired
    @Qualifier("memberCheckService")
    private MemberCheckService checkService;

    @Autowired
    @Qualifier("memberLoginService")
    private MemberLoginService loginService;

    @Autowired
    @Qualifier("memberChangePasswordService")
    private MemberChangePasswordService changeService;

    @Autowired
    @Qualifier("memberLoginCheckService")
    private MemberLoginCheckService loginCheck;


    @GetMapping("/signup")
    public String signup(){
        return "signUp";
    }

    @PostMapping("/signup")
    public @ResponseBody HashMap<String,String> register(HttpServletRequest request){
        HashMap<String,String> res = new HashMap<>();
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String nickname = request.getParameter("nickname");

        MemberVO member = MemberVO.builder()
                .email(email)
                .password(pass)
                .nickname(nickname)
                .build();

        System.out.println(email+","+pass+","+nickname);
        insertService.doService(member);
        res.put("result","true");
        res.put("message","회원가입 완료");
        return res;
    }

    @PostMapping("/signup/check")
    public @ResponseBody HashMap<String,String> signUpCheck(HttpServletRequest request){
        String column = request.getParameter("column");
        String value = request.getParameter(column);
        boolean res = checkService.doService(column,value);

        String prefix = res ? "사용 가능한 " : "이미 존재하는 ";
        String suffix = " 입니다. ";

        HashMap<String,String> result = new HashMap<>();
        result.put("result",String.valueOf(res));
        result.put("message",prefix+column+suffix);
        value = res ? value : "";
        result.put(column,value);
        return result;
    }

    @PostMapping("/login")
    @ResponseBody
    public HashMap<String,String> login(HttpServletRequest request){
        HashMap<String, String> res = new HashMap<>();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        MemberVO member = loginService.doService(email,password);
        HttpSession session = null ;
        if(member == null){
            res.put("errno","1");
            res.put("message","아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        else{
            res.put("errno","0");
            res.put("message","로그인이 완료되었습니다.");
            res.put("result","true");
            session = request.getSession();
            session.setAttribute("result",true);
            session.setAttribute("userInfo",member);
        }
        return res;
    }
    @PostMapping("/login/check")
    @ResponseBody
    public HashMap<String,String> loginCheck(HttpServletRequest request){
        HashMap<String, String> res = new HashMap<>();
        boolean check = loginCheck.doService(request);
        res.put("result",String.valueOf(check));
        if(!check){
            res.put("message","로그인을 해주세요");
        }
        return res;
    }

    @PostMapping("/logout")
    @ResponseBody
    public HashMap<String, String> logout(HttpServletRequest request){
        HashMap<String, String >res = new HashMap<>();
        HttpSession session = request.getSession(false);
        session.setAttribute("result",false);
        session.invalidate();
        res.put("result","false");
        res.put("message","로그아웃 처리되었습니다.");
        res.put("errno","0");
        return res;
    }

    @PostMapping("/change/password")
    @ResponseBody
    public HashMap<String ,String >changePass(HttpServletRequest request){
        System.out.println("changePass()");
        HashMap<String, String >res = new HashMap<>();
        HttpSession session = request.getSession(false);
        MemberVO member = (MemberVO)session.getAttribute("userInfo");
        member.setPassword(request.getParameter("changepass"));
        changeService.doService(member);
        res.put("message","비밀번호 변경 완료");
        System.out.println(member.getEmail()+","+member.getNickname()+","+member.getPassword());
        return res;
    }
}
