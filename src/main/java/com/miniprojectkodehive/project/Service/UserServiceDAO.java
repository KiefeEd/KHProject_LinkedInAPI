package com.miniprojectkodehive.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniprojectkodehive.project.model.UserModel;
import com.miniprojectkodehive.project.model.UserModelOutput;
import com.miniprojectkodehive.project.repository.UserDAO;

@Service
public class UserServiceDAO {
	@Autowired
	UserDAO userRepository;
	public void addUser(UserModel u) {
		userRepository.addUser(u);
	
	}
	
	public List<UserModelOutput> listUser(int page) {
		return userRepository.listUser(page);
	}
	public List<UserModelOutput> listBySkill(String skill) {
		return userRepository.listBySkill(skill);
	}
	public void editUser(UserModel u, int id) {
		userRepository.editUser(u, id);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteUser(id);
	}
	}


