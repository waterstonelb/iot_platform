package com.example.iot_rule.sceneService.mapper;

import com.example.iot_rule.sceneService.po.ScenePO;
import com.example.iot_rule.sceneService.vo.SceneFormVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Name:
 * DESCRIPTION:
 *
 * @author 孙刘博
 * @date 2020/6/13 14:15
 * @Version 1.0
 */
@Component
@Mapper
public interface SceneServiceMapper {

    int addScene(SceneFormVO sceneFormVO);

    List<ScenePO> getAllScenes(int id);

}
