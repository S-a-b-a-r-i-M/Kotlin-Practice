package intermediate;

import java.util.Arrays;

enum TEA{
    LEMON_TEA,
    GINGER_TEA,
    SUKKU_TEA
}

enum DESIGNATION{
    MD(1),
    CEO(1),
    MANAGER(3),
    STAFF(4);

    final int value;
    DESIGNATION(int value){
        this.value = value;
    }

    static DESIGNATION fromValue(int value){
        for (DESIGNATION i : DESIGNATION.values())
            if (value == i.value) return i;
        return null;
    }
}

public class EnumsJ {
     static TEA getFavTea(){
         return switch ((int) (Math.random() * 3)) {
             case 1 -> TEA.GINGER_TEA;
             case 2 -> TEA.LEMON_TEA;
             default -> TEA.SUKKU_TEA;
         };
     }

    public static void main(String[] args) {
        TEA favTea = getFavTea();
        switch (favTea){ // It won't enforce to check every case
            case TEA.GINGER_TEA:
                System.out.println("GINGER_TEA");
                break;
            case TEA.SUKKU_TEA:
                System.out.println("SUKKU_TEA");
                break;
        }

        System.out.println("All DESIGNATIONS : " + Arrays.toString(DESIGNATION.values()));
        System.out.println("Manager by string : " + DESIGNATION.valueOf("MANAGER"));
        System.out.println("Position of staff : " + DESIGNATION.STAFF.ordinal());
        System.out.println("Value of 1 in DESIGNATION : " + DESIGNATION.fromValue(1));
        System.out.println("Value of 1 in DESIGNATION : " + DESIGNATION.fromValue(3));
        System.out.println("Value of 1 in DESIGNATION : " + DESIGNATION.fromValue(34));

        System.out.println("\n------------------- Kotlin Enums -----------------------------");
        Subject favSub = Subject.MATHEMATICS;
        StatusInt status = StatusInt.COMPLETED;
        System.out.println("StatusInt entries: " + StatusInt.getEntries());
        System.out.println("Value of COMPLETED : " + status.getValue());
    }
}
