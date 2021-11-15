package com.jobportal.search.main.dto;

import java.util.List;

import lombok.Data;

@Data
public class SearchJobSDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1620941160477430981L;

	private Long id;
	private String companyName;
	private String jobTitle;
	private String jobDescrption;
	private String jobType;
	private List<String> education;
	private List<String> skill;
	private List<String> location;

}
