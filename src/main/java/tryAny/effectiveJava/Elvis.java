package tryAny.effectiveJava;

import java.io.Serializable;
import java.util.Arrays;

//非 transient プロパティを含む不完全なシングルトン実装
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    // 非 transient なプロパティ
    private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() {
        return INSTANCE;
    }
}