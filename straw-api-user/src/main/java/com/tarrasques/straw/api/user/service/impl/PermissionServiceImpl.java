package com.tarrasques.straw.api.user.service.impl;

import com.tarrasques.straw.commons.model.Permission;
import com.tarrasques.straw.api.user.mapper.PermissionMapper;
import com.tarrasques.straw.api.user.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
