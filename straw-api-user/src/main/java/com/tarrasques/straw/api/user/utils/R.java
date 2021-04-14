package com.tarrasques.straw.api.user.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class R implements Serializable {
    /**
     * @state 状态码
     * @message 提示消息
     */
    private Integer state;
    private String message;

    public R(){}

    public R(Integer state){
        this.state = state;
    }

    public static R OK(){
        return new R(1);
    }

    public static  R failed(Integer state,Throwable e){
        R r = new R();
        r.setState(state);
        r.setMessage(e.getMessage());
        return r;
    }

    public interface State {
        Integer ERR_USERNAME_DUPLICATE = 4000;
        Integer ERR_PHONE_DUPLICATE = 4001;
        Integer ERR_INVITE_CODE = 4002;
        Integer ERR_CLASS_DISABLED = 4003;
        Integer ERR_INSERT = 4004;
        Integer ERR_ILLEGAL_PARAMETER=4006;
        Integer ERR_UNKNOWN = 9000;
    }
}
