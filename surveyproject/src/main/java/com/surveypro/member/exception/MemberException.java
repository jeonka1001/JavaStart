package com.surveypro.member.exception;

public class MemberException extends RuntimeException{

    public MemberException(){
        this("member error");

    }
    public MemberException(String message){
        super(message);
    }
}
