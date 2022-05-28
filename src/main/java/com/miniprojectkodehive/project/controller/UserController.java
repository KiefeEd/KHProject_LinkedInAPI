package com.miniprojectkodehive.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniprojectkodehive.project.Service.SkillsServiceDAO;
import com.miniprojectkodehive.project.Service.UserServiceDAO;
// Skills
import com.miniprojectkodehive.project.model.SkillsList;
// User
import com.miniprojectkodehive.project.model.UserModel;
import com.miniprojectkodehive.project.model.UserModelOutput;
@Component
@RestController
public class UserController {
	//Skills
	@Autowired
	SkillsServiceDAO skillServiceDao;
	@Autowired
	UserServiceDAO userServiceDao;
	@PostMapping("/skills/add")
	public String addSkill(@RequestBody SkillsList s) 
	{
		return skillServiceDao.addSkill(s)+" Added to database.";
	}
	@GetMapping("/skills/view")
	public List<SkillsList> listSkill(){
		return skillServiceDao.listSkill();
	}
	@PostMapping("/skills/delete/{id}")
	public String removeSkill(@PathVariable int id) 
	{
		return skillServiceDao.removeSkill(id)+" Removed from database.";
	}
	@PostMapping("/skills/edit/{id}")
	public String editSkill(@RequestBody SkillsList s, @PathVariable int id) {
		 skillServiceDao.editSkill(s, id);
		 return "Edited database.";
	}
	
	
	//User
	@PostMapping("/users/add")
	public String addUser(@RequestBody UserModel u) 
	{
		userServiceDao.addUser(u);
		return " Added to database.";
	}
	
	@GetMapping("/users/view/{page}")
	public List<UserModelOutput> findAll(@PathVariable int page){
		return userServiceDao.listUser(page);
	}
	
	@GetMapping("/users/view/filterby/{skill}")
	public List<UserModelOutput> listBySkill(@PathVariable String skill){
		return userServiceDao.listBySkill(skill);
	}
	

	
@PostMapping("/users/edit/{id}")
public String editUser(@RequestBody UserModel u, @PathVariable int id) 
{
	userServiceDao.editUser(u, id);
	return "Edited database.";
}

@GetMapping("/users/delete/{id}") 
public String deleteUser(@PathVariable int id) 
{
	userServiceDao.deleteUser(id);
	return "Deleted user from database.";
}


}

