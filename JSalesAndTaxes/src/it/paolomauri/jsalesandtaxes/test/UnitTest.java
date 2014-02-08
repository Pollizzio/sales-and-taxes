package it.paolomauri.jsalesandtaxes.test;

import static org.junit.Assert.*;
import it.paolomauri.jsalesandtaxes.domain.BasketItem;
import it.paolomauri.jsalesandtaxes.domain.Book;
import it.paolomauri.jsalesandtaxes.domain.Food;
import it.paolomauri.jsalesandtaxes.domain.MedicalProduct;
import it.paolomauri.jsalesandtaxes.domain.ShoppingBasket;
import it.paolomauri.jsalesandtaxes.domain.TaxableGood;

import org.junit.Test;

public class UnitTest {

	@Test
	public void testExample1() {
		TaxableGood good1 = new Book(12.49f, "book", false);
		TaxableGood good2 = new TaxableGood(14.99f, "music CD", false);
		TaxableGood good3 = new Food(0.85f, "chocolate bar", false);
		
		ShoppingBasket basket = new ShoppingBasket();
		basket.addItemToBasket(new BasketItem(good1, 1));
		basket.addItemToBasket(new BasketItem(good2, 1));
		basket.addItemToBasket(new BasketItem(good3, 1));
		
		basket.printReceipt();
		
		assertArrayEquals(new float[]{1.5f, 29.83f}, 
				new float[]{basket.getTotalTaxes(), basket.getTotalCost()},
				0);
	}
	
	@Test
	public void testExample2(){
		TaxableGood good1 = new Food(10f, "box of chocolates", true);
		TaxableGood good2 = new TaxableGood(47.5f, "bottle of perfume", true);		
		
		ShoppingBasket basket = new ShoppingBasket();
		basket.addItemToBasket(new BasketItem(good1, 1));
		basket.addItemToBasket(new BasketItem(good2, 1));
		
		basket.printReceipt();
		
		assertArrayEquals(new float[]{7.65f, 65.15f}, 
				new float[]{basket.getTotalTaxes(), basket.getTotalCost()},
				0);
	}

	@Test
	public void testExample3(){
		TaxableGood good1 = new TaxableGood(27.99f, "bottle of perfume", true);
		TaxableGood good2 = new TaxableGood(18.99f, "bottle of perfume", false);
		TaxableGood good3 = new MedicalProduct(9.75f, "packet of headache pills bar", false);
		TaxableGood good4 = new Food(11.25f, "box of chocolates", true);
		
		ShoppingBasket basket = new ShoppingBasket();
		basket.addItemToBasket(new BasketItem(good1, 1));
		basket.addItemToBasket(new BasketItem(good2, 1));
		basket.addItemToBasket(new BasketItem(good3, 1));
		basket.addItemToBasket(new BasketItem(good4, 1));
		
		basket.printReceipt();
		
		assertArrayEquals(new float[]{6.70f, 74.68f}, 
				new float[]{basket.getTotalTaxes(), basket.getTotalCost()},
				0);
	}
}
