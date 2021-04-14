package com.tarrasques.straw.api.user.service.impl;

import com.tarrasques.straw.api.user.model.UserQuestion;
import com.tarrasques.straw.api.user.mapper.UserQuestionMapper;
import com.tarrasques.straw.api.user.service.IUserQuestionService;
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
public class UserQuestionServiceImpl extends ServiceImpl<UserQuestionMapper, UserQuestion> implements IUserQuestionService {

}
