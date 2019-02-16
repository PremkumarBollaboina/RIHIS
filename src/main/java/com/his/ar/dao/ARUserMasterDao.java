package com.his.ar.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.ar.entity.ARUserMaster;

public interface ARUserMasterDao extends JpaRepository<ARUserMaster, Serializable> {

}
