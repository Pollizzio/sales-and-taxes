package it.paolomauri.jsalesandtaxes.domain;

public class Book extends TaxableGood {

	public Book(float price, String description, boolean imported) {
		super(price, description, imported);
	}

}
