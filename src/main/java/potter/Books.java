package potter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Books {

    private final int PRICE = 8;
    private List<Book> books = new ArrayList<>();
    private Discount discounts;

    public Books() {
        discounts = new Discount();
    }

    public boolean exist(Book newBook) {
        for(Book book : books) {
            if(book.equals(newBook))
                return true;
        }

        return false;
    }

    public void add(Book book) {
        books.add(book);
    }

    public double price() {
        if(books.size() == 0) {
            return 0;
        }
        double discount = discounts.get(books.size());
        return books.size() * PRICE * discount;
    }
}
