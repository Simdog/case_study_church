package com.tekglobal.casestudyexample.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.models.UserInfo;
import com.tekglobal.casestudyexample.repositories.UserInfoRepository;

@Service
@Transactional
public class UserInfoService {
	@Autowired UserInfoRepository repo;
	
	 public void save(UserInfo userInfo) {
	        repo.save(userInfo);
	    }
	     
	 public List<UserInfo> findAll (){
		return (List<UserInfo>) repo.findAll();
	 }
	     
	 
	 public void addUserInfo(Long id, String email, String firstName, String lastName, String address, String phoneNumber, Date dateJoined, ChurchMember member) {
		 repo.save(new UserInfo(id, email, firstName, lastName, address, phoneNumber, member ));
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
	     
	     public List<UserInfo> getUserInfo (ChurchMember member) {
	    	 List<UserInfo> filteredUsers = new ArrayList<UserInfo>();
	    	 Iterable<UserInfo> aList = repo.findAll();
	    	 for (UserInfo uInfo: aList) {
	    		 if(uInfo.getId().equals(member.getId())) {
	    			 filteredUsers.add(uInfo);
	    		 }
	    		
	    	 }
	    	  return filteredUsers;
	    	 }
	     
	    
	     
	    public void delete(Long id) {
	        repo.deleteById(id);
	    }
	     
	    public List<UserInfo> search(String keyword) {
	        return repo.search(keyword);
	    }
	    
	
}
