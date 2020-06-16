package com.example.iot_manager.dao;

import com.example.iot_manager.data.DeviceDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceDo, Integer> {

  @Query("select d from DeviceDo d")
  Page<DeviceDo> findAllDevice(Pageable pageble);

  DeviceDo findByDeviceId(int id);

  DeviceDo findByDeviceName(String name);

  Page<DeviceDo> findByDeviceNameLike(String nameLike, Pageable pageble);

  void deleteByDeviceId(int id);

  @Modifying
  @Query("update DeviceDo d set d.groupId=?1 where d.deviceId=?2")
  void updateGroup(int groupId, int deviceId);

  @Modifying
  @Query("update DeviceDo d set d.isOnline=?1, d.onlineTime=?3 where d.deviceId= ?2 ")
  void updateIsOnline(int isonline, int id, Date onlineTime);

  @Modifying
  @Query("update DeviceDo d set d.deviceStatus=?1 where d.deviceId=?2")
  void updateDeviceStatus(int status, int id);

  @Modifying
  @Query("update DeviceDo d set d.groupId=?1 where d.groupId=?2")
  void updateDeviceGroup(int gid, int did);

  Page<DeviceDo> findByGroupId(int groupId, Pageable pageble );


}
