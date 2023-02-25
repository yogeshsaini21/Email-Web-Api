package com.masai.team6.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="types")
@NoArgsConstructor
@Getter
@Setter
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer typeId;
	
	@Column(name="typetitle" , length = 100 , nullable = false)
	private String typeTitle;
	
	
}
