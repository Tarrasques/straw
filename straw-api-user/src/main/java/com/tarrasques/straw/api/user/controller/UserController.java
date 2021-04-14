package com.tarrasques.straw.api.user.controller;


import com.tarrasques.straw.api.user.utils.R;
import com.tarrasques.straw.api.user.dto.RegisterStudentDTO;
import com.tarrasques.straw.api.user.ex.IllegalParameterException;
import com.tarrasques.straw.api.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tarrasques
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    IUserService service;
    @Autowired
    GlobalExceptionHandler globalExceptionHandler;

    @RequestMapping("/reg")
    public R reg(@Valid RegisterStudentDTO dto, BindingResult result, HttpServletRequest request) {
        System.out.println("准备注册");
        System.out.println("注册函数：" + dto);
        System.out.println("开始处理");
        if (result.hasErrors()) {
            String message = result.getFieldError().getDefaultMessage();
            throw new IllegalParameterException(message);
        }
        service.registerStudent(dto);
        return R.OK();
    }
}
