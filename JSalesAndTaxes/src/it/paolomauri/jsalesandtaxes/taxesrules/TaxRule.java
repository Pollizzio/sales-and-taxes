package it.paolomauri.jsalesandtaxes.taxesrules;

import it.paolomauri.jsalesandtaxes.domain.Good;

public interface TaxRule {
	public float calculateTax(Good item);
}
