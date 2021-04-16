package com.tarrasques.straw.gateway.mapper;

import com.tarrasques.straw.commons.model.Permission;
import com.tarrasques.straw.gateway.vo.PermissionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    /**
     * c查询用户权限表
     * @param username 用户名
     * @return 权限列表
     */
    List<PermissionVO> findByUsername(String username);
}
