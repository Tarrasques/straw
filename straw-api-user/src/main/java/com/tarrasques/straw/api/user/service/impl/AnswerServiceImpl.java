package com.tarrasques.straw.api.user.service.impl;

import com.tarrasques.straw.api.user.model.Answer;
import com.tarrasques.straw.api.user.mapper.AnswerMapper;
import com.tarrasques.straw.api.user.service.IAnswerService;
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
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements IAnswerService {

}
