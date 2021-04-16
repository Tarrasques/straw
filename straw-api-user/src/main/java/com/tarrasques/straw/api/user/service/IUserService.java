package com.tarrasques.straw.api.user.service;

import com.tarrasques.straw.api.user.dto.RegisterStudentDTO;
import com.tarrasques.straw.commons.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tarrasques
 * @since 2021-04-13
 */
public interface IUserService extends IService<User> {

    /**
     * 学生注册
     * @param studentDTO 注册信息
     */
    void registerStudent(RegisterStudentDTO studentDTO);
}
