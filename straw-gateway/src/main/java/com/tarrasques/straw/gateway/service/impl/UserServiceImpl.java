package com.tarrasques.straw.gateway.service.impl;

import com.tarrasques.straw.commons.model.User;
import com.tarrasques.straw.gateway.mapper.UserMapper;
import com.tarrasques.straw.gateway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper mapper;

    @Override
    public User getUserInfo(String username) {
        return mapper.findByUsername(username);
    }
}
