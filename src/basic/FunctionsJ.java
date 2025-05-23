package basic;

public class FunctionsJ {
    public static void main(String[] args) {
        System.out.println("Sum of 10, 15 is : " + Functions.sum(10, 15));
//        Functions.addStudent(7, "Dhoni", "05/02/2002", "MS"); // Error
        Functions.addStudent(7, "Dhoni", "");
    }
}
