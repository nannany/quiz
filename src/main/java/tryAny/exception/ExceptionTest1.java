package tryAny.exception;

public class ExceptionTest1 {
    public static void main(String[] args) {
	try {
	    x();
	} catch (Throwable e) {
	    while (e != null) {
		System.out.println(e.getMessage());
		e = e.getCause();
	    }
	    /**
	     * from x</br>
	     * from y</br>
	     * from z
	     */
	}
    }

    static void x() throws Exception {
	try {
	    y();
	} catch (Exception e) {
	    throw new Exception("from x", e);
	}
    }

    static void y() throws Exception {
	try {
	    z();
	} catch (Exception e) {
	    throw new Exception("from y", e);
	}
    }

    static void z() throws Exception {
	throw new Exception("from z");
    }
}
