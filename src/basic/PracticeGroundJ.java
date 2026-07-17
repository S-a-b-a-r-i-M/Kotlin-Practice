package basic;

import org.jetbrains.annotations.NotNull;

public class PracticeGroundJ {

    private static void whoAmI() {
        System.out.println("PracticeGround In JAVA");
    }

    public static void main(String[] args) {
        String a = (String) null;
        PracticeGroundJ objNull = (PracticeGroundJ) null;
        PracticeGroundJ obj = (PracticeGroundJ) objNull;
        whoAmI();
    }
}
