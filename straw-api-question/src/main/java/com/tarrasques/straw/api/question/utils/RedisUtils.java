package com.tarrasques.straw.api.question.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 操作redis服务器中数据的工具类
 */
@Component
public class RedisUtils {
    @Autowired
    RedisTemplate<String, Serializable> template;

    /**
     * 删除redis中的某个数据
     *
     * @param key 被删除的数据的key
     * @return 删除操作是否成功
     */
    public boolean delete(String key) {
        return template.delete(key);
    }

    /**
     * 向redis中某个list集合中添加集合元素
     *
     * @param key   传递的key
     * @param value 需要存入的元素值
     * @return
     */
    public Long rightPush(String key, Serializable value) {
        ListOperations<String, Serializable> list = template.opsForList();
        return list.rightPush(key, value);
    }

    /**
     * 获取redis中某list集合
     *
     * @param key 获取数据在redis中的key
     * @return 返货数据list集合
     */
    public List<Serializable> listRange(String key) {
        ListOperations<String, Serializable> listOperations = template.opsForList();
        long start = 0;
        long end = listOperations.size(key);
        return listOperations.range(key, start, end);
    }

    /**
     * 获取redis中某list集合中的数据片段
     *
     * @param key   获取数据在redis中的key
     * @param start 起始位置
     * @param end   结束位置
     * @return list集合的数据片段
     */
    public List<Serializable> listRange(String key, long start, long end) {
        ListOperations<String, Serializable> listOperations = template.opsForList();
        return listOperations.range(key, start, end);
    }
}
