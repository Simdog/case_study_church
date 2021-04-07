package com.tekglobal.casestudyexample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.models.Tithe;

public interface TitheRepository extends CrudRepository<Tithe, Long> {
//	@Query("SELECT t FROM Tithe t WHERE t.TITHEID = :keyword")
//    public List<Tithe> search(@Param("keyword") String keyword);

	


}
