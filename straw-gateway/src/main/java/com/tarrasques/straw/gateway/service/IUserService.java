package com.tarrasques.straw.gateway.service;

import com.tarrasques.straw.commons.model.User;

public interface IUserService {
    User getUserInfo(String username);
}
