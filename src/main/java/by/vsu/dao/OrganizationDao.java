package by.vsu.dao;

import by.vsu.domain.Organization;

import java.util.*;

public class OrganizationDao {
	private static final Map<Integer, Organization> organizations = new HashMap<>();
	static {
		organizations.put(123, build(123, "Лесная поляна", true, 34.56));
		organizations.put(45, build(45, "Заря коммунизма", false, 123.45));
		organizations.put(67, build(67, "Мазолово", false, 234.56));
		organizations.put(89, build(89, "Возрождение", true, 45.67));
	}

	public static List<Organization> readAll() {
		return new ArrayList<>(organizations.values());
	}

	public static Organization read(Integer id) {
		return organizations.get(id);
	}

	public static void create(Organization organization) {
		int newId = 1;
		if(organizations.keySet().isEmpty()) {
			newId += Collections.max(organizations.keySet());
		}
		organization.setId(newId);
		organizations.put(newId, organization);
	}

	public static void update(Organization organization) {
		if(organizations.containsKey(organization.getId())) {
			organizations.put(organization.getId(), organization);
		}
	}

	public static void delete(Integer id) {
		organizations.remove(id);
	}

	private static Organization build(Integer id, String name, boolean individual, Double area) {
		Organization organization = new Organization();
		organization.setId(id);
		organization.setName(name);
		organization.setIndividual(individual);
		organization.setArea(area);
		return organization;
	}
}
