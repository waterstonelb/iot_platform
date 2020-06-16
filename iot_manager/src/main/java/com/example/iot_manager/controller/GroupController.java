package com.example.iot_manager.controller;

import com.example.iot_manager.data.GroupDo;
import com.example.iot_manager.service.GroupService;
import com.example.iot_manager.vo.GroupVO;
import com.example.iot_manager.vo.PageResult;
import com.example.iot_manager.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController {

  final
  GroupService groupService;

  @Autowired
  public GroupController(GroupService groupService) {
    this.groupService = groupService;
  }

  @ApiOperation("添加组")
  @PostMapping("/add")
  public ResponseVO<String> addGroup(@RequestBody GroupVO groupVO) {
    return groupService.addGroup(groupVO);
  }

  @ApiOperation("更新组")
  @PostMapping("/update")
  public ResponseVO<String> updateGroup(@RequestParam int groupId, @RequestBody GroupVO groupVO){
    return groupService.updateGroup(groupId, groupVO);
  }

  @ApiOperation("删除组")
  @DeleteMapping("/delete")
  public ResponseVO<String> deleteGroup(int groupId){
    return groupService.deleteGroup(groupId);
  }

  @ApiOperation("获取全部组")
  @GetMapping("/getall")
  public ResponseVO<PageResult<GroupDo>> getAllGroup(int page, int size){
    return groupService.getAllGroup(page, size);
  }

  @ApiOperation("根据groupId获取组")
  @GetMapping("/get")
  public ResponseVO<GroupDo> getGroup(int groupId){
    return groupService.getGroup(groupId);
  }

}
