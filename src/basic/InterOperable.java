package basic;


public class InterOperable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) return;
        this.name = name;
    }

    public static void main(String[] args){
        // Calling Kotlin function
        // By default, all the global functions in kotlin are static
        int difference = Functions.sub(10, 2);
        System.out.println("Difference b/w 10 and 2 is : " + difference);

        // Calling A Function Which Has Default value Params
        int sum = Functions.sum(5, 6);
        System.out.println("Sum of 5 and 6 : " + sum);
    }
}
