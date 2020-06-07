package com.example.iot_manager.dao;

import com.example.iot_manager.data.ShadowDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShadowRepository extends JpaRepository<ShadowDo, Integer> {

    ShadowDo findByShadowId(int id);

    void deleteByShadowId(int id);
}
