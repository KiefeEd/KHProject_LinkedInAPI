package com.miniprojectkodehive.project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniprojectkodehive.project.model.UserModel;
import com.miniprojectkodehive.project.model.UserModelOutput;

@Repository
public class UserDAO {
	@Autowired
	JdbcTemplate jdbc;

	public void addUser(UserModel u) {
		jdbc.update("insert into user(jk, nama, nomor_telpon, pendidikan, tahun_lulus)"
				+ "values"
				+ "(?,?,?,?,?)", new Object[] {u.getJk(), u.getNama(), u.getNomor_telpon(), u.getPendidikan(), u.getTahun_lulus()});
		
		@SuppressWarnings("deprecation")
		int userID = jdbc.queryForObject("select u.id from user u where u.nomor_telpon=?", new Object[] { u.getNomor_telpon()}, Integer.class);
		
		for(int i: u.getSkills()) {
			jdbc.update("insert into user_skills(skill_id, user_id) values(?,?)", new Object[] {i, userID});
		}
		
	}
	
public List<UserModelOutput> listUser(int page) {
		int starts = 1;
		if(page < 2) {
			starts = 0;
		} else {
			 starts = starts * 10 * page-1;
		}
		return jdbc.query("select u.id, u.nama, u.pendidikan, u.tahun_lulus, u.jk, u.nomor_telpon, group_concat(l.nama) as \"skills\" from user u join user_skills s on s.user_id = u.id join skills_list l on s.skill_id = l.id\r\n"
				+ "group by u.id, u.nama, u.pendidikan, u.tahun_lulus, u.jk, u.nomor_telpon LIMIT ?,10;", new Object[] { starts }, new BeanPropertyRowMapper<UserModelOutput>(UserModelOutput.class));
}

public List<UserModelOutput> listBySkill(String skill) {
		return jdbc.query("select u.id, u.nama, u.pendidikan, u.tahun_lulus, u.jk, u.nomor_telpon, group_concat(l.nama) as \"skills\" from user u join user_skills s on s.user_id = u.id join skills_list l on s.skill_id = l.id\r\n"
			+ "group by u.id, u.nama, u.pendidikan, u.tahun_lulus, u.jk, u.nomor_telpon having find_in_set(?,skills)>0", new Object[] { skill }, new BeanPropertyRowMapper<UserModelOutput>(UserModelOutput.class));
}

public void editUser(UserModel u, int id) {
	jdbc.update("update user u set u.jk=?, u.nama=?, u.nomor_telpon=?, u.pendidikan=?, u.tahun_lulus=? where u.id=?", new Object[] {u.getJk(), u.getNama(), u.getNomor_telpon(), u.getPendidikan(), u.getTahun_lulus(), id});
	jdbc.update("delete from user_skills u where u.user_id=?", new Object[] {id});
	for(int i: u.getSkills()) {
		jdbc.update("insert into user_skills(skill_id, user_id) values(?,?)", new Object[] {i, id});
	}
	
}
public void deleteUser(int id) {
	jdbc.update("delete from user u where u.id=?", new Object[] {id});
	jdbc.update("delete from user_skills s where s.user_id=?", new Object[] {id});
}


}
