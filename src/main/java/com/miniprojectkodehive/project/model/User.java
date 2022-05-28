package com.miniprojectkodehive.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nama;
	private String pendidikan;
	private int tahun_lulus;
	private String jk;
	private String nomor_telpon;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getPendidikan() {
		return pendidikan;
	}
	public void setPendidikan(String pendidikan) {
		this.pendidikan = pendidikan;
	}
	public int getTahun_lulus() {
		return tahun_lulus;
	}
	public void setTahun_lulus(int tahun_lulus) {
		this.tahun_lulus = tahun_lulus;
	}
	public String getJk() {
		return jk;
	}
	public void setJk(String jk) {
		this.jk = jk;
	}
	public String getNomor_telpon() {
		return nomor_telpon;
	}
	public void setNomor_telpon(String nomor_telpon) {
		this.nomor_telpon = nomor_telpon;
	}

}
