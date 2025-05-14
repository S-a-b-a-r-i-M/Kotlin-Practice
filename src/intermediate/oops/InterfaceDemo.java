package intermediate.oops;

import org.jetbrains.annotations.NotNull;

interface JavaCar {
    String brand = ""; // By default, public, static, and final.
    default void start() { // This be
        System.out.println(this.getClass().getName());
    }

    void stop();
}

interface JavaRobot extends JavaCar {
    int power = 0; // By default, this is static final
    default void start(){
        System.out.println(this.getClass().getName());
        System.out.println("hello");
        System.out.println(brand);
    }
}

class JavaEvCar implements Car {

    @Override
    @NotNull
    public String getModel() {
        return "";
    }

    @Override
    public void setModel(@NotNull String s) {

    }

    @Override
    public void start() {

    }

    // *NOTE: This is how we can implement default methods from kotlin interface to java.
    @Override
    public void stop() {
        Car.DefaultImpls.stop(this);
    }

    @Override
    public void fillFuel() {

    }
}

public class InterfaceDemo implements JavaRobot{

    @Override
    public void start() {
        JavaRobot.super.start();
    }

    @Override
    public void stop() {

    }

    public static void main(String[] args) {
        InterfaceDemo interfaceDemo = new InterfaceDemo();

        System.out.println(InterfaceDemo.power); // Accessing by class

        JavaEvCar javaEvCar = new JavaEvCar();
        javaEvCar.stop();
    }
}

