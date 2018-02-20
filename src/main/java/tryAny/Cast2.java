package tryAny;

public class Cast2 {
    public static void main(String[] args) {
	A a = new A();
	B b = (B) a; // コンパイルは通るが、実行時ClassCastException発生
    }

}

class A {

}

class B extends A {

}

