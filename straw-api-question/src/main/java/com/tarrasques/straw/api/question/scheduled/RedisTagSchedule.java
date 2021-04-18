package com.tarrasques.straw.api.question.scheduled;

import com.tarrasques.straw.api.question.service.ITagService;
import com.tarrasques.straw.api.question.utils.RedisUtils;
import com.tarrasques.straw.api.question.vo.TagVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Slf4j
public class RedisTagSchedule {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    ITagService service;

    @Scheduled(fixedRate = 10 * 1000)
    public void updateRedisTag() {
        log.debug("[{}]准备更新redis服务器中的缓存的标签列表",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        //redis中标签列表数据的key
        String tagListKey = "tags";
        //删除数据，避免反复增加列表元素，或某些列表元素在没有MySQL中更新后在redis中无法处理
        redisUtils.delete(tagListKey);
        //充数据库中读取新的标签列表
        List<TagVO> list = service.getTagList();
        //遍历标签列表并向redis中逐一添加数据
        for (TagVO c : list) {
            //向redis中添加数据
            redisUtils.rightPush(tagListKey, c);
        }
        //日志
        log.debug("[{}]更新redis服务器中缓存的标签列表，完成！",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }
}
