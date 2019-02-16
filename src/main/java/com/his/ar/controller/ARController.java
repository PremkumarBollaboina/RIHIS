package com.his.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.his.ar.entity.ARUserMaster;
import com.his.ar.model.UserMaster;
import com.his.ar.service.ARService;
import com.his.util.AppConstants;
/**
 * this class is controller class
 * @author Nitish
 *
 */
@Controller
public class ARController {
     
	@Autowired
	private ARService arService;
	
  @RequestMapping(value="/regApp", method = RequestMethod.GET)
		public String regPageLaunch(Model model)
		{
	    
		model.addAttribute("regApp",new UserMaster());
	    return "regApp";
		}

		/**
		 * this method is used for submit the case worker form
		 * @param us
		 * @param model
		 * @return
		 */
		
	   @RequestMapping(value="/regApp",method=RequestMethod.POST)
		public String regPage(@ModelAttribute("regApp")UserMaster us,Model model)
		{
		UserMaster master=arService.saveUser(us);
	
		
			if (master!=null) {
		    model.addAttribute(AppConstants.SUCCESS, AppConstants.REG_SUCCESS);
	
			}
			else {
			model.addAttribute(AppConstants.ERROR, AppConstants.REG_ERROR);
			}
	        return "regApp";
		}
		

}