package by.vsu.domain;

/**
 * Показатель, например, удой (для коров), яйценосность (для кур) и т.п.
 */
public class Property {
	private Integer id;
	String name;
	private Animal animal;

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
}
