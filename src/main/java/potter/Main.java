package potter;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();

        Book book = new Book();
        book.tome = 0;

        Book book2 = new Book();
        book2.tome = 0;

        Book book3 = new Book();
        book3.tome = 1;

        Book book4 = new Book();
        book4.tome = 1;

        Book book5 = new Book();
        book5.tome = 2;

        Book book6 = new Book();
        book6.tome = 2;

        Book book7 = new Book();
        book7.tome = 3;

        Book book8 = new Book();
        book8.tome = 4;


        basket.addBook(book);
        basket.addBook(book2);
        basket.addBook(book3);
        basket.addBook(book4);
        basket.addBook(book5);
        basket.addBook(book6);
        basket.addBook(book7);
        basket.addBook(book8);

        System.out.println(basket.estimate());

    }
}
