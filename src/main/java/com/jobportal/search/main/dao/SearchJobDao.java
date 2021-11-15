package com.jobportal.search.main.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobportal.search.main.model.SearchJobEntity;

@Component
public class SearchJobDao {

	@Autowired
	private SearchJobRepository searchJobRepository;

	public Collection<SearchJobEntity> getAllByLocation(String location) {
		return searchJobRepository.findByLocationIgnoreCase(location);
	}

	public Collection<SearchJobEntity> getAllBySkill(String skill) {
		return searchJobRepository.findBySkillLikeIgnoreCase(skill);
	}

}
