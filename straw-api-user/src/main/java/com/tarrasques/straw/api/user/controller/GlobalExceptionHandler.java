package com.tarrasques.straw.api.user.controller;

import com.tarrasques.straw.commons.utils.R;
import com.tarrasques.straw.api.user.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public R handleException(Throwable e) {
        if (e instanceof UsernameDuplicateException) {
            return R.failed(R.State.ERR_USERNAME_DUPLICATE,e);
        }else if(e instanceof PhoneDuplicateException){
            return R.failed(R.State.ERR_PHONE_DUPLICATE,e);
        }else if(e instanceof InviteCodeException){
            return R.failed(R.State.ERR_INVITE_CODE,e);
        }else if(e instanceof ClassDisabledException){
            return R.failed(R.State.ERR_CLASS_DISABLED,e);
        }else if(e instanceof InsertException){
            return R.failed(R.State.ERR_INSERT,e);
        }else if(e instanceof IllegalParameterException){
            return R.failed(R.State.ERR_ILLEGAL_PARAMETER,e);
        }else {
            return R.failed(R.State.ERR_UNKNOWN,e);
        }
    }
}
