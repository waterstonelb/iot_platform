package com.example.iot_manager.controller;

import com.example.iot_manager.data.GroupDo;
import com.example.iot_manager.service.GroupService;
import com.example.iot_manager.vo.GroupVO;
import com.example.iot_manager.vo.ResponseVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {

  final
  GroupService groupService;

  @Autowired
  public GroupController(GroupService groupService) {
    this.groupService = groupService;
  }

  @PostMapping("/add")
  public ResponseVO<String> addGroup(@RequestBody GroupVO groupVO) {
    return groupService.addGroup(groupVO);
  }

  @PostMapping("/update")
  public ResponseVO<String> updateGroup(@RequestParam int groupId, @RequestBody GroupVO groupVO){
    return groupService.updateGroup(groupId, groupVO);
  }

  @DeleteMapping("/delete")
  public ResponseVO<String> deleteGroup(int groupId){
    return groupService.deleteGroup(groupId);
  }

  @GetMapping("/getall")
  public ResponseVO<List<GroupDo>> getAllGroup(int page, int size){
    return groupService.getAllGroup(page, size);
  }

  @GetMapping("/get")
  public ResponseVO<GroupDo> getGroup(int groupId){
    return groupService.getGroup(groupId);
  }

}
