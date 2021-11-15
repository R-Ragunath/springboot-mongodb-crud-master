package com.jobportal.search.main.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JOB_DETAILS")
public class SearchJobEntity {
	@Id
	private Long id;
	private String companyName;
	private String jobTitle;
	private String jobDescrption;
	private String jobType;
	private List<String> education;
	private List<String> skill;
	private List<String> location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescrption() {
		return jobDescrption;
	}

	public void setJobDescrption(String jobDescrption) {
		this.jobDescrption = jobDescrption;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public List<String> getEducation() {
		return education;
	}

	public void setEducation(List<String> education) {
		this.education = education;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}

	public List<String> getLocation() {
		return location;
	}

	public void setLocation(List<String> location) {
		this.location = location;
	}

	public SearchJobEntity(Long id, String companyName, String jobTitle, String jobDescrption, String jobType,
			List<String> education, List<String> skill, List<String> location) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.jobDescrption = jobDescrption;
		this.jobType = jobType;
		this.education = education;
		this.skill = skill;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", companyName=" + companyName + ", jobTitle=" + jobTitle + ", jobDescrption="
				+ jobDescrption + ", jobType=" + jobType + ", education=" + education + ", skill=" + skill
				+ ", location=" + location + "]";
	}

//    public Person(@JsonProperty("id") Long id,
//                  @JsonProperty("name") String name) {
//        this.id = id;
//        this.name = name;
//    }

}
