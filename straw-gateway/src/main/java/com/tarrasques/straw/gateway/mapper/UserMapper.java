package com.tarrasques.straw.gateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tarrasques.straw.commons.model.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tarrasques
 * @since 2021-04-13
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查找用户数据
     * @param username 用户名
     * @return 用户数据
     */
    User findByUsername(String username);
}
