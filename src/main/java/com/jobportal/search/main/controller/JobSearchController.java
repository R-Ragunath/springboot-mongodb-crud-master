package com.jobportal.search.main.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.search.main.dto.ResponseStatus;
import com.jobportal.search.main.service.JobSearchService;

@RestController
@RequestMapping("/rest/search")
public class JobSearchController {

	@Autowired
	private JobSearchService jobSearchService;
	
	private static final Logger logger = LogManager.getLogger(JobSearchController.class);

	@GetMapping("/byLocation")
	public ResponseEntity<?> searchByLocation(@RequestParam(required = true) String location) {
		logger.debug("[searchByLocation]",location);
		ResponseStatus byLocation = jobSearchService.getAllByLocation(location);
		HttpHeaders headers = new HttpHeaders();
		if (byLocation.isSuccess()) {
			logger.debug("[searchByLocation] [isSuccess]");
			return new ResponseEntity<>(byLocation, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(byLocation, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/bySkill")
	public ResponseEntity<?> searchBySkill(@RequestParam(required = true) String skill) {
		logger.debug("[searchBySkill]",skill);
		ResponseStatus bySkill = jobSearchService.getAllBySkill(skill);
		HttpHeaders headers = new HttpHeaders();
		if (bySkill.isSuccess()) {
			logger.debug("[searchBySkill] [isSuccess]");
			return new ResponseEntity<>(bySkill, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(bySkill, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
