package intermediate;

public class ExtensionFunctionJ {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle vehicle2 = new Tractor();
        Tractor tractor = new Tractor();

        ExtensionFunctionKt.stop(vehicle);
        ExtensionFunctionKt.stop(vehicle2);
        ExtensionFunctionKt.stop(tractor);
    }
}
