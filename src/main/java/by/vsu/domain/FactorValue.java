package by.vsu.domain;

/**
 * Значение для фактора
 */
public class FactorValue {
	private Integer id;
	private String name;
	private Factor factor;

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

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}
}
