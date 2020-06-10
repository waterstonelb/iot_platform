package com.example.iot_rule.ruleService.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @NAME: PageRequest
 * @DESCRIPTION: 这里是分页请求类
 * @Author: 孙刘博
 * @DATE: 2020/6/8
 * @Version: 1.0
 **/
@Getter
@Setter
public class PageRequest {

    private int pageNum;//当前页码

    private int pageSize;//每页数量

    public PageRequest(int pageNum, int pageSize){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
    }

    public PageRequest(){
    }
}
