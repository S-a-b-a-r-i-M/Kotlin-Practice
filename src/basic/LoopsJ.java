package basic;

public class LoopsJ {

    public static void main(String[] args) {
        // Breaking outer loop by using label
        int i = 0, j = 0;
        labelOuter:
        for (; i<10; i++){
            for (j = 0; j<i; j++){
                System.out.println("i "+ i +", j " + j);
                if ((i+j) % 3 == 0 && (i+j) % 5 ==0)
                    break labelOuter;
            }
        }

        System.out.println("End of the loop values of i, j are "+ i +", "+ j);
    }
}
