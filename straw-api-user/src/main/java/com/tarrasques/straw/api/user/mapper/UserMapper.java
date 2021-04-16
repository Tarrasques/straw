package com.tarrasques.straw.api.user.mapper;

import com.tarrasques.straw.commons.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    /**
     * 根据手机号查找用户数据
     * @param phone 手机号
     * @return 用户数据
     */
    User findByPhone(String phone);
}
