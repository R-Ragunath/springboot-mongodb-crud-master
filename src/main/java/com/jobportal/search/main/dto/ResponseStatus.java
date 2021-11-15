package com.jobportal.search.main.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ResponseStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2160361939410320438L;

	protected List<SearchJobSDO> jobSDO;
	protected String statusCode;
	protected String statusMessage;
	protected boolean success;
	protected ZonedDateTime timestamp;
}
