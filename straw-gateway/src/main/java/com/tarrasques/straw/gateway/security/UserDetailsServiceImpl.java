package com.tarrasques.straw.gateway.security;

import com.tarrasques.straw.commons.model.User;
import com.tarrasques.straw.commons.security.LoginUserInfo;
import com.tarrasques.straw.gateway.mapper.PermissionMapper;
import com.tarrasques.straw.gateway.service.IPermissionService;
import com.tarrasques.straw.gateway.service.IUserService;
import com.tarrasques.straw.gateway.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserService userService;
    @Autowired
    IPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息，查询不到就返回null
        User user = userService.getUserInfo(username);
        if (user==null){
            return null;
        }
        //查询用户权限列表
        List<PermissionVO> uSerPermissions = permissionService.getUSerPermissions(username);
        //基于权限列表创建集合
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        for (PermissionVO permissionVO : uSerPermissions){
            list.add(new SimpleGrantedAuthority(permissionVO.getAuthority()));
        }
        // 关于构造方法的参数，在构造方法的括号中按下Ctrl+P可以提示参数列表
        // String username：用户名
        // String password：密码
        // boolean enabled：账号是否启用
        // boolean accountNonExpired：账号是否未过期
        // boolean credentialsNonExpired：证书是否未过期
        // boolean accountNonLocked：账号未被锁定
        // Collection<? extends GrantedAuthority> authorities：权限列表
        LoginUserInfo loginUserInfo = new LoginUserInfo(
                user.getUsername(),
                user.getPassword(),
                user.getIsEnabled() == 1,
                true,true,
                user.getIsLocked()==0,
                list
        );
        loginUserInfo.setId(user.getId());
        loginUserInfo.setNickname(user.getNickname());

        //返回用户信息
        return loginUserInfo;
    }


}
