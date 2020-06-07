package com.example.iot_manager.dao;

import com.example.iot_manager.data.DeviceDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceDo, Integer> {

    @Query("select d from DeviceDo d")
    Page<DeviceDo> findAllDevice(Pageable pageble);

    DeviceDo findByDeviceId(int deviceId);

    Page<DeviceDo> findByDeviceNameLike(String nameLike, Pageable pageble);

    void deleteByDeviceId(int deviceId);
}
