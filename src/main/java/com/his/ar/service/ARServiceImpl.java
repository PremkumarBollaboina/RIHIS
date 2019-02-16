package com.his.ar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.ar.dao.ARUserMasterDao;
import com.his.ar.entity.ARUserMaster;
import com.his.ar.model.UserMaster;
/***
 * this class is used to business operation in the case worker
 * @author Nitish
 *
 */
@Service("arService")
public class ARServiceImpl implements ARService {

	@Autowired(required=false)
	private ARUserMasterDao arUserMasterdao;
	@Override
	public UserMaster saveUser(UserMaster um)
	{
		ARUserMaster entity=new ARUserMaster();
		
		BeanUtils.copyProperties(um, entity);
         entity.setSsn(um.getSsn1()+um.getSsn2()+um.getSsn3());
		arUserMasterdao.save(entity);
		return um;

}
	
		}
	





