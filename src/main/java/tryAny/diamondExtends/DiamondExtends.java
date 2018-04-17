package tryAny.diamondExtends;

public class DiamondExtends implements B, C {
    public static void main(String[] args) {
	DiamondExtends de = new DiamondExtends();
	de.x();// I am C.を出力
    }
}
