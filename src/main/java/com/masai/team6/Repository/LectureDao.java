package com.masai.team6.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.team6.Entities.Lecture;

@Repository
public interface LectureDao extends JpaRepository<Lecture , Integer> {


	List<Lecture> findByBatchIdAndSectionId(Integer batchId , Integer sectionId);
	
}
