package com.tarrasques.straw.api.question.service.impl;

import com.tarrasques.straw.api.question.mapper.TagMapper;
import com.tarrasques.straw.api.question.service.ITagService;
import com.tarrasques.straw.api.question.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    TagMapper mapper;

    @Override
    public List<TagVO> getTagList() {
        return mapper.findAll();
    }
}
