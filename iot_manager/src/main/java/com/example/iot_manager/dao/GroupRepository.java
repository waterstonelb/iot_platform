package com.example.iot_manager.dao;

import com.example.iot_manager.data.DeviceDo;
import com.example.iot_manager.data.GroupDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupDo, Integer> {

    @Query("select d from GroupDo d")
    Page<DeviceDo> findAllGroup(Pageable pagebale);

    GroupDo findByGroupId(int id);

    void deleteByGroupId(int id);
}
