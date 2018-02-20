package tryAny;

public class Extends {
    public static void main(String[] args) {
	Tmp tmp = new Tmp2();
	System.out.println(tmp.ret(1));
    }
}

abstract class Tmp {
    abstract Object ret(int i);
}

class Tmp2 extends Tmp {
    @Override
    Integer ret(int i) {
	return i;
    }

}