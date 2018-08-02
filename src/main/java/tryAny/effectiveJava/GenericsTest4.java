package tryAny.effectiveJava;

import java.util.Arrays;

public class GenericsTest4 {

    private int size;
    transient Object[] elementData; // non-private to simplify nested class access

    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elementData, size, a.getClass());
            return result;
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
}
