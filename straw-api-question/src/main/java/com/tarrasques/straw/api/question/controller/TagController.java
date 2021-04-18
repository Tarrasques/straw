package com.tarrasques.straw.api.question.controller;

import com.tarrasques.straw.api.question.utils.RedisUtils;
import com.tarrasques.straw.commons.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/tags")
public class TagController {

    @Autowired
    RedisUtils utils;

    @GetMapping("")
    public com.tarrasques.straw.commons.utils.R getTagsList() {
        return R.OK(utils.listRange("tags"));
    }
}
