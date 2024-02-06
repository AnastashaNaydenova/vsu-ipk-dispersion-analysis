package by.vsu.dao;

import by.vsu.domain.Animal;
import by.vsu.domain.Factor;
import by.vsu.domain.FactorValue;

import java.util.*;
import java.util.stream.Collectors;

public class FactorDao {
	private static final Map<Integer, Factor> factors = new HashMap<>();
	static {
		factors.put(1, build(
			1,
			"Линия производителя",
			1,
			build(1, "Карабуга"),
			build(2, "Оноприй"),
			build(3, "Кипрей")
		));
		factors.put(2, build(
			2,
			"Сезон",
			1,
			build(4, "Весна"),
			build(5, "Лето"),
			build(6, "Осень"),
			build(7, "Зима")
		));
		factors.put(3, build(
			3,
			"Линия производителя",
			2,
			build(8, "Кузя"),
			build(9, "Сеня"),
			build(10, "Бублик"),
			build(11, "Мирон")
		));
		factors.put(4, build(
			4,
			"Порода",
			2,
			build(12, "Ландрас"),
			build(13, "Дюрок")
		));
		factors.put(5, build(
			5,
			"Порода",
			3,
			build(14, "Авиколор"),
			build(15, "Амрокс"),
			build(16, "Барневельдер"),
			build(17, "Галан"),
			build(18, "Корниш")
		));
	}

	public static List<Factor> readByAnimal(Integer animalId) {
		return factors.values().stream().filter(factor -> factor.getAnimal().getId().equals(animalId)).collect(Collectors.toList());
	}

	public static Factor read(Integer id) {
		return factors.get(id);
	}

	public static void create(Factor factor) {
		int newId = 1;
		if(factors.keySet().isEmpty()) {
			newId += Collections.max(factors.keySet());
		}
		factor.setId(newId);
		factors.put(newId, factor);
	}

	public static void update(Factor factor) {
		if(factors.containsKey(factor.getId())) {
			factors.put(factor.getId(), factor);
		}
	}

	public static void delete(Integer id) {
		factors.remove(id);
	}

	private static Factor build(Integer id, String name, Integer animalId, FactorValue ... values) {
		Factor factor = new Factor();
		factor.setId(id);
		factor.setName(name);
		factor.setAnimal(new Animal());
		factor.getAnimal().setId(animalId);
		factor.setValues(Arrays.stream(values).collect(Collectors.toList()));
		return factor;
	}

	private static FactorValue build(Integer id, String name) {
		FactorValue factorValue = new FactorValue();
		factorValue.setId(id);
		factorValue.setName(name);
		return factorValue;
	}
}
