package com.tarrasques.straw.api.question;

import com.tarrasques.straw.api.question.mapper.TagMapper;
import com.tarrasques.straw.api.question.service.impl.TagServiceImpl;
import com.tarrasques.straw.api.question.vo.TagVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@SpringBootTest
@Slf4j
class StrawApiQuestionApplicationTests {

    @Autowired
    TagServiceImpl mapper;

    @Test
    void contextLoads() {

    }

}
