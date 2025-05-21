package intermediate.oops;

public interface RobotJ {
    String name = "";

    String getName();

    void start();
    default void stop(){
        System.out.println("Default implementation for crackers.stop inside Robot" + this.getName());
    }
    void charge();
}
