package com.adl.main.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="player")
public class PlayerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Agar Auto Increment
	private int id;
	
	private String username;
	private String level;
	private String kelas;
}
