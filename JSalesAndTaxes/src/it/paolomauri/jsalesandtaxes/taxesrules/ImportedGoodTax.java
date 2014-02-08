package it.paolomauri.jsalesandtaxes.taxesrules;

import it.paolomauri.jsalesandtaxes.domain.Good;

public class ImportedGoodTax implements TaxRule {
	private static float TAX_RATE = 0.05f;

	@Override
	public float calculateTax(Good good) {
		if(good.isImported()){
			return good.getPrice() * TAX_RATE;
		} else {
			return 0;
		}
	}
}
