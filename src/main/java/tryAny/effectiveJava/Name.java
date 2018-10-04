package tryAny.effectiveJava;

import java.io.Serializable;

// Good candidate for default serialized form
public class Name implements Serializable {

    /**
     * must be non-null
     * @serial
     */
    private final String lastName;

    /**
     * must be non-null
     * @serial
     */
    private final String firstName;

    /**
     * Middle name, or null if there is none
     * @serial
     */
    private final String middleName;

    public Name(String lastName, String firstName, String middleName) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

}
