package it.paolomauri.jsalesandtaxes.domain;

import it.paolomauri.jsalesandtaxes.utilities.PriceFormatter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
	private List<BasketItem> mItems;
	private float mTotalTaxes;
	private float mTotalCost;	

	public ShoppingBasket() {
		mItems = new ArrayList<BasketItem>();
	}

	public void addItemToBasket(BasketItem item) {
		mItems.add(item);
	}

	public void printReceipt() {
		resetBasket();
		StringBuilder buf = new StringBuilder();
		for(BasketItem item : mItems) {
			buf.append("\n").append(item.toString());
			mTotalCost += item.getTaxIncludedPrice();
			mTotalTaxes += item.getTaxes();
		}
		buf.append("\nSales Tax: " + PriceFormatter.format(mTotalTaxes));
		buf.append("\nTotal: " + PriceFormatter.format(mTotalCost));
		System.out.println(buf.toString());
	}

	private void resetBasket() {
		mTotalCost = 0.0f;
		mTotalTaxes = 0.0f;
	}

	public float getTotalCost() {
		return mTotalCost;
	}

	public float getTotalTaxes() {
		return mTotalTaxes;
	}
}
