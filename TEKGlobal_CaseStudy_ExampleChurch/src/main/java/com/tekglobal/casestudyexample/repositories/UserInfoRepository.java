package com.tekglobal.casestudyexample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tekglobal.casestudyexample.models.Attendance;
import com.tekglobal.casestudyexample.models.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>  {
@Query("SELECT u FROM UserInfo u WHERE u.email = :keyword")
    public List<UserInfo> search(@Param("keyword") String keyword);

Optional<UserInfo> findById(Long id);

UserInfo findById(Integer id);

UserInfo findById(String id);

}
