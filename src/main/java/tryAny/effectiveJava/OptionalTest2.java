package tryAny.effectiveJava;

import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();
        Optional<ProcessHandle> parentProcess = ph.parent();

        System.out.println(
                "Parent PID: " + (parentProcess.isPresent() ? String.valueOf(parentProcess.get().pid()) : "N/A"));

        // better
        System.out.println("Parent PID: " + ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));

    }
}
