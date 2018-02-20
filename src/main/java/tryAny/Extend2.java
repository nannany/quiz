package tryAny;

public class Extend2 {
    public static void main(String[] args) {
	E e = new F();
	F f = new F();
	System.out.println(e.tmp); // 1
	System.out.println(f.tmp); // 2
	System.out.println(f.getTmp());// 1

    }
}

class E {
    int tmp = 1;

    int getTmp() {
	return this.tmp;
    }
}

class F extends E {
    int tmp = 2;
}