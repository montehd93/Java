package entities;

public class Individual extends TaxPayer {
	private Double healtExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healtExpenditures) {
		super(name, anualIncome);
		this.healtExpenditures = healtExpenditures;
	}


	@Override
	public Double tax() {
		if (getAnualIncome() < 20000.0) {
			return getAnualIncome() * 0.15 - healtExpenditures * 0.5;
		}
		else {
			return getAnualIncome() * 0.25 - healtExpenditures * 0.5;
		}
	}
}
