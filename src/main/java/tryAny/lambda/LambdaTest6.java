package tryAny.lambda;

public class LambdaTest6 {
    public static void main(String[] args) {
        Flyable f = AirPlane::new;
        AirPlane ap = f.getAirPlane("ana");

        System.out.println(ap);
    }
}

class AirPlane {
    private String name;

    public AirPlane(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "constructor " + this.name;
    }
}
