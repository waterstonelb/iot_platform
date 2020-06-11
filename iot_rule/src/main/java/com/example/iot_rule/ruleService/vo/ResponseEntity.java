package com.example.iot_rule.ruleService.vo;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName: ResponseEntity
 * @Description:  统一返回类
 * @Author: 孙刘博
 * @Date: 2020/6/8
 * @Version: 1.0
 **/

@Getter
@Setter
public class ResponseEntity<T> {

    private String msg;
    private T content;
    private int pageNum;//当前页码

    private int pageSize;//每页数量

    private long totalSize;//记录总数

    private int totalPages;//页码总数

    public ResponseEntity(T content) {
        this.content = content;
        this.msg = "成功";
    }

    public ResponseEntity(T content, String msg) {
        this.msg = msg;
        this.content = content;
    }

    public ResponseEntity(T content, int pageNum, int pageSize, long totalSize, int totalPages) {
        this.msg = "成功";
        this.content = content;
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.totalSize=totalSize;
        this.totalPages=totalPages;
    }

    public ResponseEntity(T content, String msg, int pageNum, int pageSize, long totalSize, int totalPages) {
        this.msg = msg;
        this.content = content;
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.totalSize=totalSize;
        this.totalPages=totalPages;
    }

    public static ResponseEntity PageTool(PageInfo<?> pageInfo) {
        return new ResponseEntity(pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize()
                ,pageInfo.getTotal(),pageInfo.getPages());
    }

    public static ResponseEntity PageTool(PageInfo<?> pageInfo, List<?> content) {
        return new ResponseEntity(content,pageInfo.getPageNum(),pageInfo.getPageSize()
                ,pageInfo.getTotal(),pageInfo.getPages());
    }
}
