package basic;

public class HandlingNullJ {
    public static void main(String[] args) {
        String mobileBrand = HandlingNullKt.getBrand();
//        System.out.println(mobileBrand != null ? mobileBrand.length() : 0);
        System.out.println(mobileBrand.length());
    }
}
