package com.jobportal.search.main.service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.search.main.dao.SearchJobDao;
import com.jobportal.search.main.dto.ResponseStatus;
import com.jobportal.search.main.dto.SearchJobSDO;
import com.jobportal.search.main.model.SearchJobEntity;

@Service
public class JobSearchService {

	@Autowired
	private SearchJobDao dao;

	@Autowired
	private OrikaBeanMapper mapper;

	public ResponseStatus getAllByLocation(String location) {
		ResponseStatus statusResponse = new ResponseStatus();
		if (null == location || location.isEmpty()) {
			statusResponse.setStatusCode("Error");
			statusResponse.setStatusMessage("Validation Error, location can't be Empty...");
			statusResponse.setSuccess(false);
			statusResponse.setTimestamp(ZonedDateTime.now());
			return statusResponse;
		}
		Collection<SearchJobEntity> allByLocation = dao.getAllByLocation(location);
		List<SearchJobSDO> searchResource = mapper.mapAsList(allByLocation, SearchJobSDO.class);
		statusResponse.setJobSDO(searchResource);
		statusResponse.setStatusCode("SUCCESS");
		statusResponse.setStatusMessage("Success");
		statusResponse.setSuccess(true);
		statusResponse.setTimestamp(ZonedDateTime.now());
		return statusResponse;
	}

	public ResponseStatus getAllBySkill(String skill) {
		ResponseStatus statusResponse = new ResponseStatus();
		if (null == skill || skill.isEmpty()) {
			statusResponse.setStatusCode("Error");
			statusResponse.setStatusMessage("Validation Error, skill can't be Empty...");
			statusResponse.setSuccess(false);
			return statusResponse;
		}
		Collection<SearchJobEntity> allBySkill = dao.getAllBySkill(skill);
		List<SearchJobSDO> searchResource = mapper.mapAsList(allBySkill, SearchJobSDO.class);
		statusResponse.setJobSDO(searchResource);
		statusResponse.setStatusCode("SUCCESS");
		statusResponse.setStatusMessage("Success");
		statusResponse.setSuccess(true);
		statusResponse.setTimestamp(ZonedDateTime.now());
		return statusResponse;

	}

}
