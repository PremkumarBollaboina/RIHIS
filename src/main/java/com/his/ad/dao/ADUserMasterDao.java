package com.his.ad.dao;

import java.io.Serializable;

/***
 * this is class user for db operation
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.his.ad.entity.ADUserMaster;
@Repository("adUserMasterDao")
public interface ADUserMasterDao extends JpaRepository<ADUserMaster, Serializable> {

		 
	@Query("SELECT ad FROM ADUserMaster ad where ad.email=:email")
	 ADUserMaster findByEmail(@Param("email") String email);
  
/***
 * this is used for app login for case worker
 * @param email
 * @param pwd
 * @param activeSw
 * @return class object
 */
	@Query("SELECT ad FROM ADUserMaster ad where ad.email =:email and pwd =:pwd")
	ADUserMaster findUserByEmailAndPwd(@Param("email")String email, @Param("pwd")String pwd);


}
