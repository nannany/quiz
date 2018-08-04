package tryAny.effectiveJava;

public class StackTest {
    // Little program to exercise our generic Stack
    public static void main(String[] args) {
        Stack3<String> stack = new Stack3<>();
        for (String arg : args)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }

}
