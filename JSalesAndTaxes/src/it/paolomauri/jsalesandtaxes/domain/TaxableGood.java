package it.paolomauri.jsalesandtaxes.domain;

import it.paolomauri.jsalesandtaxes.taxesrules.BasicSaleTax;
import it.paolomauri.jsalesandtaxes.taxesrules.ImportedGoodTax;
import it.paolomauri.jsalesandtaxes.taxesrules.TaxRule;
import it.paolomauri.jsalesandtaxes.utilities.PriceFormatter;

import java.util.ArrayList;
import java.util.List;

public class TaxableGood extends Good {
	private float mTaxes=-1; //-1=not yet calculated
	private static final float TAX_ROUND=0.05f;
	
	protected List<TaxRule> mAppliableTaxes = new ArrayList<TaxRule>();
	
	public TaxableGood(float price, String name, boolean imported) {
		super(price, name, imported);
		applyTaxRules();
	}

	private void applyTaxRules() {
		//Adding here all tax rules applicable for a good
		mAppliableTaxes.add(new ImportedGoodTax());
		mAppliableTaxes.add(new BasicSaleTax());
	}

	public float getTaxes(){
		//Checking if taxes already calculated and cached
		if(mTaxes==-1){
			float taxes=0;
			for(TaxRule taxRule:mAppliableTaxes){
				taxes+=taxRule.calculateTax(this);
			}
			mTaxes=roundTax(taxes);
		}
		return mTaxes;
	}
	
	private float roundTax(float tax){
		return Float.parseFloat(
				PriceFormatter.format(
						(float) Math.ceil(tax/TAX_ROUND)*TAX_ROUND));	
	}
	
	public float getTaxIncludedPrice(){
		return mPrice + getTaxes();
	}
	
	@Override
	public String toString() {
		return (mImported?"imported ":"") + mName + " : " + PriceFormatter.format(mPrice + getTaxes());
	}
}
