package entities;

public class Individual extends Person {

	private Double healthExpenditures;

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double taxes() {
		Double tax = 0.0;
		if(super.getAnualIncome() < 20000.0) {
			tax = super.getAnualIncome() * 0.15 - 0.5 * this.getHealthExpenditures();
		} else {
			tax = super.getAnualIncome() * 0.25 - 0.5 * this.getHealthExpenditures();
		}

		return tax;
	}

	@Override
	public String toString() {
		return super.getName() + ": $ " + String.format("%.2f", this.taxes());
	}

}
