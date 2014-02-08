package it.paolomauri.jsalesandtaxes.domain;

import it.paolomauri.jsalesandtaxes.utilities.PriceFormatter;

public class Good {
	protected float mPrice;
	protected String mName;
	protected boolean mImported;
	
	/**
	 * A Class representing a good
	 * @param price The tax-free price
	 * @param name Name of the good
	 * @param imported True if It's imported
	 */
	public Good(float price, String name, boolean imported){
		mPrice=price;
		mName=name;
		mImported=imported;
	}	
	
	public float getPrice(){
		return mPrice;
	}
	
	public String getName(){
		return mName;
	}
	
	public boolean isImported(){
		return mImported;
	}
	
	@Override
	public String toString() {
		return (mImported?"imported ":"") + mName + " : " + PriceFormatter.format(mPrice);
	}
}
