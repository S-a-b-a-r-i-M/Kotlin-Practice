package advance.coroutine;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

public class InvokingCoroutineKtFromJava {

    public static void main(String[] args) {
        // Calling An Suspend Fun
        method1();
        method2();
    }

    public static void method1() {
        ApiClient.INSTANCE.fetchUserASync(5, new Continuation<String>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }

            @Override
            public void resumeWith(@NotNull Object result) {
                // Handle success and Failure
            }
        });
    }

    public static void onUserFetch( String res, Throwable exp) {

    }

    public static void method2() {
        Coroutine4Kt.fetchUserASyncWrapper(1, (res, exp) -> {
            System.out.println("res : " + res + "exp : " + exp);
            return Unit.INSTANCE;
        });
        while (true) {
            // To wait until the callback received
        }
    }
}
