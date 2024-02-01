package by.vsu.domain;

public class Data {
	private Integer id;
	private Task task;

	private FactorValue factorValue;
	private Double value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public FactorValue getFactorValue() {
		return factorValue;
	}

	public void setFactorValue(FactorValue factorValue) {
		this.factorValue = factorValue;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
