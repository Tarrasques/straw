package com.tarrasques.straw.api.question.service;

import com.tarrasques.straw.api.question.vo.TagVO;

import java.util.List;

public interface ITagService {
    List<TagVO> getTagList();
}
