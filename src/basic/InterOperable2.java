package basic;

public class InterOperable2 {
    void accessOperatorOverloading() {
        Bookshelf bookshelf = new Bookshelf();
        Book got = new Book(
                "Game of thrones",
                "James",
                1999,
                2000,
                true
        );
        // bookshelf[0] = got; // ERROR: // ❌ Java doesn't support this syntax
        bookshelf.setBook(0, new Book(
                "Game of thrones",
                "James",
                1999,
                2000,
                true
        ));
        System.out.println(bookshelf.getBook(0));
    }

    void breakLoopWithLabel() {
        outer:
        while (true) {
            switch (5) {
                default -> {
                    break outer;
                }
            }
        }

        System.out.println("Loop Ends"); // This becomes unreachable without label
    }

    public static void main(String[] args) {

    }
}
