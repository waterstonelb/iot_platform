package com.example.iot_manager.service.serviceimpl;

import com.example.iot_manager.dao.GroupRepository;
import com.example.iot_manager.data.GroupDo;
import com.example.iot_manager.service.GroupService;
import com.example.iot_manager.vo.GroupVO;
import com.example.iot_manager.vo.ResponseVO;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

  final
  GroupRepository groupRepository;
  @Autowired
  public GroupServiceImpl(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }

  @Transactional
  public ResponseVO<String> addGroup(GroupVO groupVO) {
    try{
      GroupDo groupDo=new GroupDo();
      groupDo.setGroupVO(groupVO);
      groupRepository.save(groupDo);
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> updateGroup(int groupId, GroupVO groupVO) {
    try{
      GroupDo groupDo=groupRepository.findByGroupId(groupId);
      groupDo.setGroupVO(groupVO);
      groupRepository.save(groupDo);
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  public ResponseVO<List<GroupDo>> getAllGroup(int page, int size) {
    try{
      PageRequest pageRequest=PageRequest.of(page, size);
      Page<GroupDo> groupDoPage=groupRepository.findAll(pageRequest);
      return ResponseVO.buildSuccess(groupDoPage.getContent());
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  public ResponseVO<GroupDo> getGroup(int groupId) {
    try{
      return ResponseVO.buildSuccess(groupRepository.findByGroupId(groupId));
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }

  @Transactional
  public ResponseVO<String> deleteGroup(int groupId) {
    try{
      groupRepository.deleteByGroupId(groupId);
      return ResponseVO.buildSuccess("Success");
    }catch (Exception e){
      e.printStackTrace();
      return ResponseVO.buildFailure("Fail");
    }
  }
}
