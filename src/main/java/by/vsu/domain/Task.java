package by.vsu.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Task {
	private Integer id;
	private Username username;
	private String name;
	private Date date;
	private Organization organization;
	private Property property;
	private Factor factor;
	private List<Map<FactorValue, Data>> data;

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

	public List<Map<FactorValue, Data>> getData() {
		return data;
	}

	public void setData(List<Map<FactorValue, Data>> data) {
		this.data = data;
	}
}
