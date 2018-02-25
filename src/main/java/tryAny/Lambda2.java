package tryAny;

public class Lambda2 {
    public static void main(String[] args) {
	Algo plus = (int x, int y) -> {
	    return x + y;
	};

	// ラムダ式の処理が一つしかなく、中括弧を省略した場合には、returnは省略せねばならない。
	Algo minus = (int x, int y) -> x - y;

	System.out.println(execCalc(plus, 2, 1));
	System.out.println(execCalc(minus, 2, 1));
    }

    static int execCalc(Algo algo, int x, int y) {
	return algo.calc(x, y);
    }

    @FunctionalInterface
    interface Algo {
	int calc(int x, int y);
    }
}
