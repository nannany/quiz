package tryAny.effectiveJava;

import java.io.Serializable;

//Elvis クラスを攻撃するクラス
public class ElvisStealer implements Serializable {
    // シングルトン以外のインスタンスを保持しておくための static フィールド
    static Elvis impersonator;

    // もう一つの Elvis インスタンス
    private Elvis payload;

    private Object readResolve() {
        // payload に保持されている Elvis インスタンスを impersonator に保持しておく
        impersonator = payload;

        // このプロパティを文字列配列として偽装するので文字列配列を返す
        return new String[] { "A Fool Such as I" };
    }

    private static final long serialVersionUID = 0;
}