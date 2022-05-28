package com.miniprojectkodehive.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniprojectkodehive.project.model.SkillsList;
import com.miniprojectkodehive.project.repository.SkillsDAO;

@Service
public class SkillsServiceDAO {
	@Autowired
	SkillsDAO skillsRepository;
	public int addSkill(SkillsList s) {
		return skillsRepository.addSkill(s);
	
	}
	
	
	public List<SkillsList> listSkill() {
		return skillsRepository.listSkill();
	}
	
	public int removeSkill(int id) {
		return skillsRepository.removeSkill(id);
	
	}
	public void editSkill(SkillsList s, int id) {
		skillsRepository.editSkill(s, id);
	}
}
