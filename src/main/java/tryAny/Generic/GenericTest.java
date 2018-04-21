package tryAny.Generic;

public class GenericTest<T> {
    /**
     * クラス宣言時のTと下のメソッドでのTは別物なのでこれはコンパイルできる。
     */
    static <T> T exec3(T t) {
	return t;
    }

    /** 以下はコンパイル通らない
    static T exec(T t) {
	return t;
    }
    **/
}
