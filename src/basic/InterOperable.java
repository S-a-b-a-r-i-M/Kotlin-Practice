package basic;

import intermediate.oops.Car;
import org.jetbrains.annotations.NotNull;

class EvCar implements Car {

    @Override
    @NotNull
    public String getModel() {
        return "";
    }

    @Override
    public void stop() {

    }

    @Override
    public void setModel(@NotNull String s) {

    }

    @Override
    public void start() {

    }

    @Override
    public void fillFuel() {

    }
}

public class InterOperable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) return;
        this.name = name;
    }

    public void sing(String song, Double duration){
        System.out.println("Singing songuu...");
    }

    public static void main(String[] args){
        // Calling Kotlin function
        // By default, all the global functions in kotlin are static
        int difference = Functions.sub(10, 2);
        System.out.println("Difference b/w 10 and 2 is : " + difference);

        // Calling A Function Which Has Default value Params
        int sum = Functions.sum(5, 6);
        System.out.println("Sum of 5 and 6 : " + sum);

        // INTERFACE FROM KOTLIN
        EvCar evCar = new EvCar();
//        evCar.crackers.stop();
        System.out.println(evCar.getModel());
    }
}
