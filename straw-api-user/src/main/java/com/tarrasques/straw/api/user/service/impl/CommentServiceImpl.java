package com.tarrasques.straw.api.user.service.impl;

import com.tarrasques.straw.commons.model.Comment;
import com.tarrasques.straw.api.user.mapper.CommentMapper;
import com.tarrasques.straw.api.user.service.ICommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
