package com.tarrasques.straw.api.question.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class TagVO implements Serializable {

    private Integer id;
    private String name;

}
