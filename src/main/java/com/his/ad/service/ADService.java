package com.his.ad.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.his.ad.entity.ADUserMaster;
import com.his.ad.model.UserMaster;

public interface ADService {
 
	public UserMaster saveUser(UserMaster um);
    
	public List<UserMaster> findAllUsers();
	
	public Page<ADUserMaster> findAllUsers(int pageNo,int pageSize);

	public UserMaster findUserByEmailAndPwd(String email, String pwd);
    
    public UserMaster findById(Integer userId);
    
	public UserMaster findByEmail(String email);
	
    public UserMaster findByIdEdit(int cid);

	public UserMaster saveUserUpadte(UserMaster um,boolean flage);
}
