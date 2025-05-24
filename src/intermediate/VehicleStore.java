package intermediate;

class BaseVehicle {
    void start(){
        System.out.println("BaseVehicle - started");
    }

    void stop(){
        System.out.println("BaseVehicle - stopped");
    }
}

class IndustrialTractor extends BaseVehicle {
    void start(){
        System.out.println("IndustrialTractor - started");
    }

    void stop(){
        System.out.println("IndustrialTractor - stopped");
    }

    void onExcavators(){
        System.out.println("excavators started");
    }
}

public class VehicleStore {

    static void startVehicle(BaseVehicle vehicle) {
        System.out.println("(BaseVehicle vehicle) invoked --->");
        vehicle.start();
    }

    static void startVehicle(IndustrialTractor vehicle) {
        System.out.println("(IndustrialTractor vehicle) invoked --->");
        vehicle.start();
    }

    static void stopVehicle(BaseVehicle vehicle){
        vehicle.stop();
    }

    public static void main(String[] args) {
        BaseVehicle baseVehicle = new BaseVehicle();
        BaseVehicle tractor = new IndustrialTractor();
        IndustrialTractor industrialTractor = new IndustrialTractor();

        startVehicle(baseVehicle);
        startVehicle(tractor);
        startVehicle(industrialTractor);

        stopVehicle(baseVehicle);
        stopVehicle(tractor);
        stopVehicle(industrialTractor);
    }
}


