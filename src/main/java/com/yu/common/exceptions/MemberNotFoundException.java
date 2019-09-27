package com.yu.common.exceptions;

public class MemberNotFoundException extends RuntimeException {

    MemberNotFoundException(String message){
        super(message);
    }

}
