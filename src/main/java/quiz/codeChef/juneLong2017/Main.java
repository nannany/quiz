package quiz.codeChef.juneLong2017;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static String U, V;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    U = sc.next();
	    V = sc.next();
	    BigInteger bu = new BigInteger(U);
	    BigInteger bv = new BigInteger(V);
	    BigInteger n = bu.add(bv);
	    BigInteger ans = n.multiply(n.add(new BigInteger("1"))).divide(new BigInteger("2")).add(bu)
		    .add(new BigInteger("1"));

	    System.out.println(ans.toString());
	}
	sc.close();
    }
}
