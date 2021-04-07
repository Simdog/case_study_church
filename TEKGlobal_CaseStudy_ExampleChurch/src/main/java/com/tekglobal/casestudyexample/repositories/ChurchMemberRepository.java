package com.tekglobal.casestudyexample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tekglobal.casestudyexample.models.ChurchMember;

public interface ChurchMemberRepository extends CrudRepository<ChurchMember, Long> {
	
	@Query(value="SELECT c FROM ChurchMember c WHERE c.id LIKE :keyword OR c.email LIKE :keyword OR c.lastName LIKE :keyword")
	public List<ChurchMember> search(@Param("keyword") String keyword);
	

//	@Query("select c from ChurchMember c join fetch c.userInfo")
//	public Iterable<ChurchMember> findAll();
	
	

}
