package com.masai.team6.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @Table(name="Bookmarks")
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookmarkId;
	
	private Integer userId;
	
	private Integer  lectureId;

}
