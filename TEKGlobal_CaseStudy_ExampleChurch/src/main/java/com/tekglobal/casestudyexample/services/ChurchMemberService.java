package com.tekglobal.casestudyexample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.repositories.ChurchMemberRepository;



@Service
@Transactional
public class ChurchMemberService {
    @Autowired ChurchMemberRepository repo;
//     
    public void save(ChurchMember churchmember) {
        repo.save(churchmember);
    }
     
    public List<ChurchMember> listAll() {
    	return (List<ChurchMember>) repo.findAll();
    	
    }
     
    public ChurchMember get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(Long id) {
        repo.deleteById(id);
    }
     
    public List<ChurchMember> search(String keyword) {
        return repo.search(keyword);
    }
    
//    public List<ChurchMember> findByLastNameOrId(String keyword) {
//        return repo.findByLastNameOrId(keyword);
//    }
    
    
    
}