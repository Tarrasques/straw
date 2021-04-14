package com.tarrasques.straw.api.user.service.impl;

import com.tarrasques.straw.api.user.model.Tag;
import com.tarrasques.straw.api.user.mapper.TagMapper;
import com.tarrasques.straw.api.user.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
