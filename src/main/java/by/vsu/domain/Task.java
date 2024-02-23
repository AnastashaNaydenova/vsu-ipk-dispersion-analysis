package by.vsu.domain;

import java.util.Date;
import java.util.List;

public class Task {
	private Integer id;
	private Username username;
	private String name;
	private Date date;
	private Organization organization;
	private Property property;
	private Factor factor;
	private List<Data> data;
	private Double influenceProportion;
	private boolean veracity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Username getUsername() {
		return username;
	}

	public void setUsername(Username username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public Double getInfluenceProportion() {
		return influenceProportion;
	}

	public void setInfluenceProportion(Double influenceProportion) {
		this.influenceProportion = influenceProportion;
	}

	public boolean isVeracity() {
		return veracity;
	}

	public void setVeracity(boolean veracity) {
		this.veracity = veracity;
	}
}
