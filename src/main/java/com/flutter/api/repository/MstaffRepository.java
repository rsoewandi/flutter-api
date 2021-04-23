package com.flutter.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flutter.api.model.Mstaff;

@Repository
public interface MstaffRepository extends CrudRepository<Mstaff, Long>{
	
	Mstaff findByStaffid(String staffId);
	List<Mstaff> findAll();
}
