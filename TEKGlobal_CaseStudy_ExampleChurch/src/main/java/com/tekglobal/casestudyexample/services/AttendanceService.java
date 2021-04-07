package com.tekglobal.casestudyexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekglobal.casestudyexample.models.Attendance;
import com.tekglobal.casestudyexample.models.Tithe;
import com.tekglobal.casestudyexample.repositories.AttendanceRepository;

@Service
@Transactional
public class AttendanceService {
	
	@Autowired AttendanceRepository repo;
	
	public void save(Attendance attendance) {
		
		repo.save(attendance);
	}
	
	public Attendance get(Long id) {
	    return repo.findById(id);
	}

	public Attendance get(Integer id) {
		// TODO Auto-generated method stub
	    return repo.findById(id);
	}

	public Attendance get(String id) {
	    return repo.findById(id);

	}
	
	


}
