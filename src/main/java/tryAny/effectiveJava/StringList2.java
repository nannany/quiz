package tryAny.effectiveJava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 改良を加えたStringList
public final class StringList2 implements Serializable {
    private transient int size = 0;
    private transient Entry head = null;

    // No longer Serializable
    private static class Entry {
        String data;
        Entry previous;
        Entry next;
    }

    // listに文字列を加える
    public final void add(String s) {

    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        for (int i = 0; i < numElements; i++) {
            add((String) s.readObject());
        }
    }
}
