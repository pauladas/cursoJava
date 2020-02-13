package entities;

public class Company extends Person {
	private Integer numberOfEmployees;

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double taxes() {
		Double tax = 0.0;

		if (this.getNumberOfEmployees() < 10) {
			tax = super.getAnualIncome() * 0.16;
		} else {
			tax = super.getAnualIncome() * 0.14;
		}

		return tax;
	}

	@Override
	public String toString() {
		return super.getName() + ": $ " + String.format("%.2f", this.taxes());
	}

}
