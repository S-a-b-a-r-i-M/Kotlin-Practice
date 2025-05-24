package intermediate.oops;

abstract class AbstractVehicleJ {
    int maxSpeed = 100;
    final String defaultColor = "red";

    abstract void start();

    void horn(){
        System.out.println("beep! beep!");
    }
}

public class AbstractClassesJ extends AbstractVehicleJ {
    float maxSpeed = 101f;

    @Override
    void start() {

    }

    public static void main(String[] args) {
        AbstractClassesJ vehicle = new AbstractClassesJ();

        // maxSpeed is got overridden
        System.out.println("initial maxSpeed: " + vehicle.maxSpeed);
    }
}
