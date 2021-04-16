package com.tarrasques.straw.api.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tarrasques.straw.api.question.vo.TagVO;
import com.tarrasques.straw.commons.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper extends BaseMapper<Tag> {
    List<TagVO> findAll();
}
