package tryAny.effectiveJava;

public class Varargs {
    public static void main(String[] args) {
        System.out.println(min1(99));
        System.out.println(min2(1, 2, 3));

    }

    // ugly
    static int min1(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Too few arguments");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];
        return min;
    }

    // better
    static int min2(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }
}
