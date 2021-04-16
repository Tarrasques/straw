package com.tarrasques.straw.api.user.service.impl;

import com.tarrasques.straw.commons.model.Question;
import com.tarrasques.straw.api.user.mapper.QuestionMapper;
import com.tarrasques.straw.api.user.service.IQuestionService;
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
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
