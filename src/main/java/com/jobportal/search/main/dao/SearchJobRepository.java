package com.jobportal.search.main.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.search.main.model.SearchJobEntity;

@Repository
public interface SearchJobRepository extends MongoRepository<SearchJobEntity, Long> {

	List<SearchJobEntity> findByLocationIgnoreCase(String location);

	List<SearchJobEntity> findBySkillLikeIgnoreCase(String skill);

}
