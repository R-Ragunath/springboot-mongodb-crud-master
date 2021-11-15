package com.jobportal.search.main.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jobportal.search.main.dao.PostJobDao;
import com.jobportal.search.main.model.SearchJobEntity;

@Service
public class PostJobService {

	private final PostJobDao personDao;

	public PostJobService(PostJobDao dao) {
		this.personDao = dao;
	}

	public SearchJobEntity insertData(SearchJobEntity entity) {
		return personDao.insertData(entity);
	}

	public Collection<SearchJobEntity> getAllInformation() {
		return personDao.getAllInformation();
	}

	public Optional<SearchJobEntity> getInformationUsingId(Long id) {
		return personDao.getInformationById(id);
	}

	public void updateUsingId(Long id, SearchJobEntity entity) {
		personDao.updateUsingId(id, entity);
	}

	public void deleteUsingId(Long id) {
		personDao.deleteUsingId(id);
	}

}
