package by.vsu.domain;

import java.util.List;

/**
 * Фактор, например, линия (производитель), сезон (зима, весна, лето, осень) и т.п.
 */
public class Factor {
	private Integer id;
	private String name;
	private Animal animal;
	private List<FactorValue> values;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<FactorValue> getValues() {
		return values;
	}

	public void setValues(List<FactorValue> values) {
		this.values = values;
	}
}
