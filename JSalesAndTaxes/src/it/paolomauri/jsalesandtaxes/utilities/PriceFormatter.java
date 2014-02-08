package it.paolomauri.jsalesandtaxes.utilities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Locale;

public class PriceFormatter {
	//Using US locale to force "point" as decimal separator
	private static final Format FORMATTER = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
	
	public static String format(float price){
		return FORMATTER.format(price);
	}
}
