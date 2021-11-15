package com.jobportal.search.main.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.search.main.model.SearchJobEntity;
import com.jobportal.search.main.service.PostJobService;

@RestController
@RequestMapping("jobs")
public class PostJobController {

	private final PostJobService jobService;

	public PostJobController(PostJobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping
	public SearchJobEntity create(@RequestBody SearchJobEntity person) {
		return jobService.insertData(person);
	}

	@GetMapping
	public Collection<SearchJobEntity> read() {
		return jobService.getAllInformation();
	}

	@GetMapping(path = "{id}")
	public Optional<SearchJobEntity> readQueryUsingId(@PathVariable("id") Long id) {
		return jobService.getInformationUsingId(id);
	}

	@PutMapping(path = "/update/{id}")
	public void update(@PathVariable Long id, @RequestBody SearchJobEntity person) {
		jobService.updateUsingId(id, person);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		jobService.deleteUsingId(id);
	}
}
