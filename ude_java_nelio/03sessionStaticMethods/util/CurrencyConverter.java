package util;

public class CurrencyConverter {

	public static double amountToBePaid(double currency, double amount) {
		double tax = 6.00;
		return (currency * amount) * (100 + tax) / 100 ;
	}
}
