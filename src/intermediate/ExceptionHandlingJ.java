package intermediate;

import java.io.FileReader;

public class ExceptionHandlingJ {

    static boolean amIEligible(int age) {
        if (age > 18)
            return true;

        throw new IllegalArgumentException("Age is not enough");
    }

    public static void main(String[] args) {
        ExceptionHandlingKt.canIVote(2);
        amIEligible(1);
        // FileReader reader = new FileReader("filePath"); // Checked exception

    }
}
