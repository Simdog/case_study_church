package com.tekglobal.casestudyexample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekglobal.casestudyexample.models.UserInfo;
import com.tekglobal.casestudyexample.repositories.UserInfoRepository;

@Service
@Transactional
public class UserInfoService {
	@Autowired UserInfoRepository repo;
	
	 public void save(UserInfo userInfo) {
	        repo.save(userInfo);
	    }
	     
	     
	    public Optional<UserInfo> get(Long id) {
	        return repo.findById(id);
	    }
	    
	    public UserInfo get(Integer id) {
	        return repo.findById(id);
	    }
	     
	    public UserInfo get(String id) {
	        return repo.findById(id);
	    }
	     
	     
	    public void delete(Long id) {
	        repo.deleteById(id);
	    }
	     
	    public List<UserInfo> search(String keyword) {
	        return repo.search(keyword);
	    }
	    
	
}
