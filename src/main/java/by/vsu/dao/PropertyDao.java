package by.vsu.dao;

import by.vsu.domain.Animal;
import by.vsu.domain.Property;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PropertyDao {
	private static final Map<Integer, Property> properties = new HashMap<>();
	static {
		properties.put(1, build(1, "Удой", 1));
		properties.put(2, build(2, "Жирность молока", 1));
		properties.put(3, build(3, "Среднесуточный привес", 2));
		properties.put(4, build(4, "Убойный вес", 2));
		properties.put(5, build(5, "Яйценосноть", 3));
	}

	public static List<Property> readByAnimal(Integer animalId) {
		return properties.values().stream().filter(property -> property.getAnimal().getId().equals(animalId)).collect(Collectors.toList());
	}

	public static Property read(Integer id) {
		return properties.get(id);
	}

	public static void create(Property property) {
		int newId = 1;
		if(properties.keySet().isEmpty()) {
			newId += Collections.max(properties.keySet());
		}
		property.setId(newId);
		properties.put(newId, property);
	}

	public static void update(Property property) {
		if(properties.containsKey(property.getId())) {
			properties.put(property.getId(), property);
		}
	}

	public static void delete(Integer id) {
		properties.remove(id);
	}

	private static Property build(Integer id, String name, Integer animalId) {
		Property property = new Property();
		property.setId(id);
		property.setName(name);
		property.setAnimal(new Animal());
		property.getAnimal().setId(animalId);
		return property;
	}
}
