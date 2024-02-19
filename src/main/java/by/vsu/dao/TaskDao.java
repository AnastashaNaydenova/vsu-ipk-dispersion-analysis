package by.vsu.dao;

import by.vsu.domain.Animal;
import by.vsu.domain.Organization;
import by.vsu.domain.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskDao {
	private static final Map<Integer, Task> tasks = new HashMap<>();
	static {
		Task task;
		task = new Task();
		task.setId(101);
		task.setName("Зачётное задание");
		task.setDate(date("07.03.2015"));
		task.setOrganization(new Organization());
		task.getOrganization().setId(1);
		task.getOrganization().setName("ВГАВМ");
		tasks.put(101, task);
		task = new Task();
		task.setId(102);
		task.setName("Лабораторное исследование");
		task.setDate(date("16.04.2023"));
		task.setOrganization(new Organization());
		task.getOrganization().setId(2);
		task.getOrganization().setName("Колхоз «Заря»");
		tasks.put(102, task);
		task = new Task();
		task.setId(103);
		task.setName("Лабораторное исследование");
		task.setDate(date("23.04.2023"));
		task.setOrganization(new Organization());
		task.getOrganization().setId(3);
		task.getOrganization().setName("ОАО «Витебская бройлерная птицефабрика»");
		tasks.put(103, task);
		task = new Task();
		task.setId(104);
		task.setName("Лабораторное исследование");
		task.setDate(date("15.05.2023"));
		task.setOrganization(new Organization());
		task.getOrganization().setId(2);
		task.getOrganization().setName("Колхоз «Заря»");
		tasks.put(104, task);
	}
	public static List<Task> readByUser(Integer userId) {
		return new ArrayList<>(tasks.values());
	}
	public static Task read(Integer id) {
		return tasks.get(id);
	}
	private static Date date(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return format.parse(date);
		} catch(ParseException e) {
			return null;
		}
	}
}
