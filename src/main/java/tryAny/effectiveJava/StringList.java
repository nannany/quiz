package tryAny.effectiveJava;

import java.io.Serializable;

// デフォルトserialized formにしてはならない！
public final class StringList implements Serializable {
    private int size = 0;
    private Entry head = null;

    private static class Entry {
        String data;
        Entry previous;
        Entry next;
    }
}
