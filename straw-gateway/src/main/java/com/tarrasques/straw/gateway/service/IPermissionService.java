package com.tarrasques.straw.gateway.service;

import com.tarrasques.straw.gateway.vo.PermissionVO;

import java.util.List;

public interface IPermissionService {
    /**
     * 查询用户权限列表
     * @param username
     * @return
     */
    List<PermissionVO> getUSerPermissions(String username);
}
