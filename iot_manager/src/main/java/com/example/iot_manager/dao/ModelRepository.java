package com.example.iot_manager.dao;

import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.data.GroupDo;
import com.example.iot_manager.data.ModelDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ModelRepository extends JpaRepository<ModelDo, Integer> {
    @Query("select d from ModelDo d")
    Page<DeviceDo> findAllModel(Pageable pagebale);

    ModelDo findByModelId(int id);

    Page<ModelDo> findByModelNameLike(String nameLike, Pageable pageble);

    void deleteByModelId(int id);

}
