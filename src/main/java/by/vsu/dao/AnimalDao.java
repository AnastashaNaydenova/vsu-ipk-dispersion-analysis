package by.vsu.dao;

import by.vsu.domain.Animal;

import java.util.*;

public class AnimalDao {
	private static final Map<Integer, Animal> animals = new HashMap<>();
	static {
		animals.put(1, build(1, "Коровы"));
		animals.put(2, build(2, "Свиньи"));
		animals.put(3, build(3, "Куры"));
	}

	public static List<Animal> readAll() {
		return new ArrayList<>(animals.values());
	}

	public static Animal read(Integer id) {
		return animals.get(id);
	}

	public static void create(Animal animal) {
		int newId = 1;
		if(animals.keySet().isEmpty()) {
			newId += Collections.max(animals.keySet());
		}
		animal.setId(newId);
		animals.put(newId, animal);
	}

	public static void update(Animal animal) {
		if(animals.containsKey(animal.getId())) {
			animals.put(animal.getId(), animal);
		}
	}

	public static void delete(Integer id) {
		animals.remove(id);
	}

	private static Animal build(Integer id, String name) {
		Animal animal = new Animal();
		animal.setId(id);
		animal.setName(name);
		return animal;
	}
}
