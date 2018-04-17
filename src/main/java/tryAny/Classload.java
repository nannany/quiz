package tryAny;

public class Classload {
    public static void main(String[] args) {
	System.out.println(Classload.class.getResource("Classload.class").toString());

	Class<Classload> clazz1 = Classload.class;
	Classload c = new Classload();
	Class<? extends Classload> clazz2 = c.getClass();
	System.out.println(System.identityHashCode(clazz1) + "," + System.identityHashCode(clazz2));
    }
}
