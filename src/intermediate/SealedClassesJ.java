package intermediate;

// NOT POSSIBLE
//class Fetching<T> extends SealedResult {
//    public Fetching(){
//
//    }
//}

public class SealedClassesJ {

    void paymentProcessor(double amount, PaymentMethod paymentMethod){
        if (paymentMethod instanceof UpiPayment)
            System.out.println("payment sent via UPI");
        else if (paymentMethod instanceof BankTransfer)
            System.out.println("payment sent via BankTransfer");
        else if (paymentMethod instanceof CreditCardPayment)
            System.out.println("payment sent via CreditCard");
    }

    public static void main(String[] args) {
        SealedResult user = SealedClassesKt.fetchUser(2);
        if (user instanceof SealedResult.Success)
            System.out.println(((SealedResult.Success<Object>) user).getData());
        else if (user instanceof SealedResult.Error)
            System.out.println(((SealedResult.Error)user).getExp().getMessage());
        else if (user instanceof Pending)
            System.out.println();


        // SealedClasses2.kt
        SealedClasses2Kt.paymentProcessor(3099, new UpiPayment("sabari@pthdfc"));
    }
}
