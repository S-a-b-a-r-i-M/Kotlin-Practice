package basic;

import intermediate.Goat;
import intermediate.oops.Car;
import org.jetbrains.annotations.NotNull;

class EvCar implements Car {
    String model;

    public EvCar(String model){
        this.model = model;
    }

    @Override
    @NotNull
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(@NotNull String s) {
        model = s;
    }

    @Override
    public void stop() {
        Car.DefaultImpls.stop(this);
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
    public int age;

    public String getName(){
        return name;
    }

    public void setName(String name) {
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
        EvCar evCar = new EvCar("TATA");
        System.out.println(evCar.getModel());
        evCar.stop();

        // Kotlin Class
        Goat whiteSheep = new Goat();
        whiteSheep.eat();
    }
}
