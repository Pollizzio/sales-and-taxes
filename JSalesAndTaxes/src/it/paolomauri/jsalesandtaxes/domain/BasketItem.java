package it.paolomauri.jsalesandtaxes.domain;

public class BasketItem {
	private TaxableGood mGood;
	private int mQuantity;

	public BasketItem(TaxableGood good, int quantity){
		if(quantity<=0){
			throw new IllegalArgumentException("quantity must be >0");
		}
		mGood=good;
		mQuantity=quantity;
	}
	
	@Override
	public String toString() {
		return mQuantity + " " + mGood.toString();
	}

	public float getTaxIncludedPrice() {		
		return mQuantity * mGood.getTaxIncludedPrice();
	}

	public float getTaxes() {
		return mQuantity * mGood.getTaxes();
	}
}
