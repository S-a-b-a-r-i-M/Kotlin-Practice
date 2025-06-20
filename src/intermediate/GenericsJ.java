package intermediate;

import kotlin.Unit;

import java.util.*;

public class GenericsJ {

    public static Unit callBack(int index, int element){
        System.out.println("index : " + index + " element: " + element);
        return Unit.INSTANCE;
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1, 3, 5, 7, 9, 11};
        ArrayUtils<Integer> arrayUtils = new ArrayUtils<>(numbers);
        System.out.println(Arrays.toString(arrayUtils.getArray()));
        // Calling a fun with lambda
        arrayUtils.findElement(11, (index, element ) -> {
            System.out.println("index : " + index + " element: " + element);
            return Unit.INSTANCE;
        });

        arrayUtils.findElement(1, (index, element) -> index != -1 ? callBack(index, element) : null);
    }
}
