package intermediate.oops;

import org.jetbrains.annotations.NotNull;

class TransformerJ implements Car {

    @Override
    @NotNull
    public String getModel() {
        return "";
    }

    @Override
    public void setModel(@NotNull String s) {

    }

    @Override
    public void stop(){

    }

    @Override
    public void start() {

    }

    @Override
    public void fillFuel() {

    }
}

class InterOperable {
    public static void main(String[] args) {
        TransformerJ shiftT = new TransformerJ();
//        shiftT.stop();
    }
}
