package entities;

public class Employee {

	private Integer id;
	private String name;
	private Double salary;
	
	// Constructors
	public Employee(Integer id, String name, Double salary) {		
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void increaseSalary(Double tax) {
		
		this.setSalary(this.getSalary() * ((tax / 100) + 1));
	}
	
	public String toString() {
		
		return String.format("%d, %s, %.2f", this.getId(), this.getName(), this.getSalary());
	}
}
