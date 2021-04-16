package com.tarrasques.straw.gateway.service.impl;

import com.tarrasques.straw.gateway.mapper.PermissionMapper;
import com.tarrasques.straw.gateway.service.IPermissionService;
import com.tarrasques.straw.gateway.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    PermissionMapper mapper;

    @Override
    public List<PermissionVO> getUSerPermissions(String username) {
        return mapper.findByUsername(username);
    }
}
