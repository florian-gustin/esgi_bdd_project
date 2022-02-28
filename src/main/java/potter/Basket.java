package potter;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Book> books = new ArrayList<>();
    private final int PRICE = 8;

    public void addBook(Book book) {
        books.add(book);
    }

    public double estimate() {
        double total = 0;
        boolean specialCase5 = false; // special case of set of 5 and 3

        // Stack book in collection (eg: 3x Tome 1)
        int[] count_book = {0,0,0,0,0};

        if(books.size() == 0)
            return 0;

        if(books.size() == 1)
            return PRICE;

        for(Book book: books) {
            count_book[book.tome] += 1;
        }

        int max = 0;

        for(int count : count_book) {
            if(count > max) {
                max = count;
            }
        }

        int[][] matrix = new int[5][];

        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[max];

            int sumBook = count_book[i] - 1;

            for(int j = 0; j < max; j++) {
                if(j <= sumBook) {
                    matrix[i][j] = i;
                }else {
                    matrix[i][j] = -1;
                }
            }

        }

        for(int i = 0; i < max; i++) {
            int sumOfBooks = 0;
            int sumOfNextBooks = 0;

            for(int j = 0; j < matrix.length; j++) {
                if(matrix[j][i] > -1) {
                    sumOfBooks += 1;
                }

                int nextIndex = max - 1;

                if(i < nextIndex) {
                    if(matrix[j][i + 1] > -1) {
                        sumOfNextBooks += 1;
                    }
                }
            }

            /*
            Pricing discount calcul
             */

            if(sumOfBooks == 5 && sumOfNextBooks == 3) {
                specialCase5 = true;

                total += (4 * PRICE * 0.8) + (4 * PRICE * 0.8);
            }else if(sumOfBooks == 5) {
                total += (5 * PRICE * 0.75);
            }else if(sumOfBooks == 4) {
                total += (4 * PRICE * 0.8);
            }else if(sumOfBooks == 3) {
                if(!specialCase5) {
                    total += (3 * PRICE * 0.9);
                }else {
                    specialCase5 = false;
                }
            }else if(sumOfBooks == 2) {
                total += (2 * PRICE * 0.95);
            }else {
                total += PRICE;
            }

        }

        return total;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "_books=" + books +
                '}';
    }
}
