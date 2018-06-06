package tryAny.effectiveJava;

import java.math.BigDecimal;

public class FloatDouble {
    public static void main(String[] args) {
	System.out.println(1.03 - 0.42);// 0.6100000000000001
	System.out.println(1.00 - 9 * 0.10);// 0.09999999999999998

	double funds = 1.00;
	int itemsBought = 0;
	for (double price = 0.10; funds >= price; price += 0.10) {
	    funds -= price;
	    itemsBought++;
	}
	System.out.println(itemsBought + " items bought.");// 3 items bought.
	System.out.println("Change: $" + funds);// Change: $0.3999999999999999

	final BigDecimal TEN_CENTS = new BigDecimal(".10");
	int itemsBought2 = 0;
	BigDecimal funds2 = new BigDecimal("1.00");
	for (BigDecimal price = TEN_CENTS; funds2.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
	    funds2 = funds2.subtract(price);
	    itemsBought2++;
	}
	System.out.println(itemsBought2 + " items bought.");//4 items bought.
	System.out.println("Money left over: $" + funds2);//Money left over: $0.00
    }
}
