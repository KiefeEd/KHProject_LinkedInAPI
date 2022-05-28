package com.miniprojectkodehive.project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniprojectkodehive.project.model.SkillsList;

@Repository
public class SkillsDAO {
	
	@Autowired
	JdbcTemplate jdbc;
	public int addSkill(SkillsList s) {
		return jdbc.update("insert into skills_list(nama)"
				+ "values"
				+ "(?)", new Object[] {s.getNama()});
		
	}
	
	public List<SkillsList> listSkill() {
		return jdbc.query("select * from skills_list", new BeanPropertyRowMapper<SkillsList>(SkillsList.class));
	}
	public int removeSkill(int id) {
		return jdbc.update("delete from skills_list s where s.id=(?)", id);
		
	}
	
	public void editSkill(SkillsList s, int id) {
		jdbc.update("update skills_list s set s.nama=? where s.id=?", new Object[] {s.getNama(), id});
	}
	
	
}
