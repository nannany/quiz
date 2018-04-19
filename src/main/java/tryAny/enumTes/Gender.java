package tryAny.enumTes;

public enum Gender {
    MAN, WOMAN, OTHER;
}

class Try {
    public static void main(String[] args) {
	System.out.println(Gender.MAN.toString());// MAN
	System.out.println(Gender.MAN.name());// MAN
	for (Gender g : Gender.values()) {
	    System.out.println(g.name() + ":" + g.ordinal());
	    /**
	     * MAN:0 </br>
	     * WOMAN:1 </br>
	     * OTHER:2
	     */
	}
	Gender g = Gender.MAN;

	trans(g);//男
    }

    public static void trans(Gender g) {
	switch (g) {
	case MAN:
	    System.out.println("男");
	    break;
	case WOMAN:
	    System.out.println("女");
	    break;
	case OTHER:
	    System.out.println("その他");
	    break;
	default:
	    assert (false);
	}
    }
}