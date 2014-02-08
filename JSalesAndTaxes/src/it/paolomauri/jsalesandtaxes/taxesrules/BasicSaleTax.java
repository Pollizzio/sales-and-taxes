package it.paolomauri.jsalesandtaxes.taxesrules;

import it.paolomauri.jsalesandtaxes.domain.Book;
import it.paolomauri.jsalesandtaxes.domain.Food;
import it.paolomauri.jsalesandtaxes.domain.Good;
import it.paolomauri.jsalesandtaxes.domain.MedicalProduct;

public class BasicSaleTax implements TaxRule {
	private static final float TAX_RATE = 0.1f;	
	
	@Override
	public float calculateTax(Good good) {
		if( !(good instanceof Book) 
				&& !(good instanceof Food)
				&& !(good instanceof MedicalProduct)){
			return good.getPrice() * TAX_RATE;	
		} else {
			return 0;
		}		
	}

}
