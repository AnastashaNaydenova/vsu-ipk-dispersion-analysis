package by.vsu.dao;

import by.vsu.domain.Factor;
import by.vsu.domain.FactorValue;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FactorValueDao {
	private static final Map<Integer, FactorValue> values = new HashMap<>();
	static {
		values.put(1, build(1, "Карабуга", 1));
		values.put(2, build(2, "Оноприй", 1));
		values.put(3, build(3, "Кипрей", 1));
		values.put(4, build(4, "Весна", 2));
		values.put(5, build(5, "Лето", 2));
		values.put(6, build(6, "Осень", 2));
		values.put(7, build(7, "Зима", 2));
		values.put(8, build(8, "Кузя", 3));
		values.put(9, build(9, "Сеня", 3));
		values.put(10, build(10, "Бублик", 3));
		values.put(11, build(11, "Мирон", 3));
		values.put(12, build(12, "Ландрас", 4));
		values.put(13, build(13, "Дюрок", 4));
		values.put(14, build(14, "Авиколор", 5));
		values.put(15, build(15, "Амрокс", 5));
		values.put(16, build(16, "Барневельдер", 5));
		values.put(17, build(17, "Галан", 5));
		values.put(18, build(18, "Корниш", 5));
	}

	public static List<FactorValue> readByFactor(Integer factorId) {
		return values.values().stream().filter(value -> value.getFactor().getId().equals(factorId)).collect(Collectors.toList());
	}

	public static FactorValue read(Integer id) {
		return values.get(id);
	}

	public static void create(FactorValue value) {
		int newId = 1;
		if(values.keySet().isEmpty()) {
			newId += Collections.max(values.keySet());
		}
		value.setId(newId);
		values.put(newId, value);
	}

	public static void update(FactorValue value) {
		if(values.containsKey(value.getId())) {
			values.put(value.getId(), value);
		}
	}

	public static void delete(Integer id) {
		values.remove(id);
	}

	private static FactorValue build(Integer id, String name, Integer factorId) {
		FactorValue value = new FactorValue();
		value.setId(id);
		value.setName(name);
		value.setFactor(new Factor());
		value.getFactor().setId(factorId);
		return value;
	}
}
