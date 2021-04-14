package com.tarrasques.straw.api.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tarrasques.straw.api.user.dto.RegisterStudentDTO;
import com.tarrasques.straw.api.user.ex.*;
import com.tarrasques.straw.api.user.mapper.ClassInfoMapper;
import com.tarrasques.straw.api.user.mapper.UserMapper;
import com.tarrasques.straw.api.user.model.ClassInfo;
import com.tarrasques.straw.api.user.model.User;
import com.tarrasques.straw.api.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tarrasques
 * @since 2021-04-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;

    @Override
    public void registerStudent(RegisterStudentDTO studentDTO) {
        System.out.println(studentDTO);
        // 从参数registerStudentDTO中取出用户名
        String username = studentDTO.getUsername();
        String phone = studentDTO.getPhone();
        // 基于以上取出的用户名，调用userMapper.findByUsername()查询用户数据
        User byUsername = userMapper.findByUsername(username);
        User byPhone = userMapper.findByPhone(phone);
        // 判断查询结果是否不为null
        if (byUsername != null) {
            // 是：根据用户名找到了用户数据，则用户名已经被注册，将抛出UsernameDuplicateException
            throw new UsernameDuplicateException("注册失败！用户名已被注册。");
        }
        if (byPhone != null){
            throw new PhoneDuplicateException("注册失败！手机号已被注册。");
        }
        // 从参数registerStudentDTO中取出邀请码
        String inviteCode = studentDTO.getInviteCode();
        // 基于以上取出的邀请码，调用classInfoMapper.selectOne()方法，根据邀请码查询班级信息
        QueryWrapper<ClassInfo> classs = new QueryWrapper<>();
        classs.eq("invite_code", inviteCode);
        ClassInfo classInfo = classInfoMapper.selectOne(classs);
        // 判断查询结果是否为null
        if (classInfo == null) {
            // 是：根据邀请码没有找到班级信息，则邀请码错误，将抛出InviteCodeException
            throw new InviteCodeException("注册失败！邀请码错误。");
        }
        // 判断以上查询到的班级信息的isEnabled是否为0
        if (classInfo.getIsEnabled() == 0) {
            // 是：班级已经被禁用，将不允许注册，将抛出ClassDisabledException
            throw new ClassDisabledException("注册失败！班级已被禁用。");
        }
        // 创建当前时间对象now
        LocalDateTime localDateTime = LocalDateTime.now();
        // 创建User对象
        User user = new User();
        // 补全user对象中的属性值：username < 从参数中获取
        user.setUsername(studentDTO.getPhone());
        // 补全user对象中的属性值：password < [暂]从参数中获取
        user.setPassword(studentDTO.getPassword());
        // 补全user对象中的属性值：nickname < 从参数中获取
        user.setNickname(studentDTO.getNickname());
        // 补全user对象中的属性值：gender < 从参数中获取
        user.setGender(studentDTO.getGender());
        // 补全user对象中的属性值：dayOfBirth < 从参数中获取
        user.setDayOfBirth(studentDTO.getDayOfBirth());
        // 补全user对象中的属性值：phone < 从参数中获取
        user.setPhone(studentDTO.getPhone());
        // 补全user对象中的属性值：classId < 从班级信息中获取
        user.setClassId(classInfo.getId());
        // 补全user对象中的属性值：isEnabled < 1
        user.setIsEnabled(1);
        // 补全user对象中的属性值：isLocked < 0
        user.setIsLocked(0);
        // 补全user对象中的属性值：accountType < 0(学生)
        user.setAccountType(0);
        // 补全user对象中的属性值：selfIntroduction < 从参数中获取
        user.setSelfIntroduction(studentDTO.getSelfIntroduction());
        // 补全user对象中的属性值：gmt_create < now
        user.setGmtCreate(localDateTime);
        // 补全user对象中的属性值：gmt_modified < now
        user.setGmtModified(localDateTime);
        // 基于以上user对象调用userMapper.insert()执行插入用户数据，并获取返回值
        int insert = userMapper.insert(user);
        // 判断返回的受影响行数是否不为1
        if (insert != 1) {
            // 是：受影响行数不是1，则插入用户数据失败，将抛出InsertException
            throw new InsertException("注册失败！服务器错误，请联系管理员。");
        }
    }

}
