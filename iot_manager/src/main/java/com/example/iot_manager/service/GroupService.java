package com.example.iot_manager.service;

import com.example.iot_manager.data.GroupDo;
import com.example.iot_manager.vo.GroupVO;
import com.example.iot_manager.vo.ResponseVO;
import java.util.List;

public interface GroupService {

  ResponseVO<String> addGroup(GroupVO groupVO);

  ResponseVO<String> updateGroup(int groupId, GroupVO groupVO);

  ResponseVO<List<GroupDo>> getAllGroup(int page, int size);

  ResponseVO<GroupDo> getGroup(int groupId);

  ResponseVO<String> deleteGroup(int groupId);
}
