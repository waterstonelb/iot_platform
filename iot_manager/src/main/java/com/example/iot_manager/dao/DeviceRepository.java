package com.example.iot_manager.dao;

import com.example.iot_manager.data.DeviceDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceDo, Integer> {

    @Query("select d from DeviceDo d")
    Page<DeviceDo> findAllDevice(Pageable pageble);

    DeviceDo findByDeviceId(int id);

    Page<DeviceDo> findByDeviceNameLike(String nameLike, Pageable pageble);

    void deleteByDeviceId(int id);

    @Query("update DeviceDo d set d.isOnline=?1 where d.deviceId= ?2 and d.onlineTime=?3")
    void updateIsOnline(int isonline, int id, Date onlineTime);

    @Query("update DeviceDo d set d.deviceStatus=?1 where d.deviceId=?2")
    void updateDeviceStatus(int status, int id);

    @Query("update DeviceDo d set d.groupId=?1 where d.groupId=?2")
    void updateDeviceGroup(int gid, int did);


}
