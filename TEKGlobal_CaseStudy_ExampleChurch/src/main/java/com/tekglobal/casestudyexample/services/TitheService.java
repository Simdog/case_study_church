package com.tekglobal.casestudyexample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekglobal.casestudyexample.models.ChurchMember;
import com.tekglobal.casestudyexample.models.Tithe;
import com.tekglobal.casestudyexample.repositories.TitheRepository;

@Service
@Transactional
public class TitheService {
@Autowired TitheRepository repo;

public void save(Tithe tithe) {

	repo.save(tithe);
	
}


public List<Tithe> listAll() {
    return (List<Tithe>) repo.findAll();
}

public Tithe get(Long id) {
    return repo.findById(id).get();
}

public void delete(Long id) {
    repo.deleteById(id);
}

public Optional<Tithe> search(Long id) {
	return repo.findById(id);
}
//public List<Tithe> search(String keyword) {
//    return repo.search(keyword);
//}

}
