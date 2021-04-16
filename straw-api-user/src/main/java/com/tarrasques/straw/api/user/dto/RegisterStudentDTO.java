package com.tarrasques.straw.api.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Accessors
public class RegisterStudentDTO implements Serializable {
    private String username;
    private String nickname;
    @Pattern(regexp = "^\\w{4,16}$",message = "注册失败！密码长度必须4~16位！")
    private String password;
    private Integer gender;
    @Pattern(regexp = "^\\d{11}$",message = "注册失败！手机号格式错误！")
    private String phone;
    private LocalDate dayOfBirth;
    private String selfIntroduction;
    private String inviteCode;
}
