package com.tarrasques.straw.api.user.service.impl;

import com.tarrasques.straw.api.user.model.Role;
import com.tarrasques.straw.api.user.mapper.RoleMapper;
import com.tarrasques.straw.api.user.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tarrasques
 * @since 2021-04-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
