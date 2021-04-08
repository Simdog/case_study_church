package com.tekglobal.casestudyexample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tekglobal.casestudyexample.models.Attendance;

public interface AttendanceRepository  extends CrudRepository<Attendance, Boolean> {

	Attendance findById(Long id);

	Attendance findById(Integer id);
	
	Attendance findById(String id);


}
