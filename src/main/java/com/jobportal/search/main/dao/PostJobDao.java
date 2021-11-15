package com.jobportal.search.main.dao;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jobportal.search.main.model.SearchJobEntity;

@Component
public class PostJobDao {

	private final SearchJobRepository repository;

	public PostJobDao(SearchJobRepository repository) {
		this.repository = repository;
	}

	public SearchJobEntity insertData(SearchJobEntity entity) {
		return repository.insert(entity);
	}

	public Collection<SearchJobEntity> getAllInformation() {
		return repository.findAll();
	}

	public Optional<SearchJobEntity> getInformationById(Long id) {
		return repository.findById(id);
	}

	public SearchJobEntity updateUsingId(Long id, SearchJobEntity entity) {
		Optional<SearchJobEntity> findQuery = repository.findById(id);
		SearchJobEntity values = findQuery.get();
		values.setId(entity.getId());
		values.setCompanyName(entity.getCompanyName());
		return repository.save(values);
	}

	public void deleteUsingId(Long id) {
		try {
			repository.deleteById(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

}
