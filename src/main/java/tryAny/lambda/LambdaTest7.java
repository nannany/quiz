package tryAny.lambda;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class LambdaTest7 {
    public static void main(String[] args) {
        // 引数でとったintを文字にして返す
        IntFunction<String> intFunc = String::valueOf;

        // 引数でとったStringの文字数を返す
        ToIntFunction<String> toIntFunc = String::length;

        System.out.println(intFunc.apply(11));
        System.out.println(toIntFunc.applyAsInt("apple"));
    }
}
