package potter;

import java.util.*;

public final class Potter {
    static public int BOOK_PRICE = 8;

    static public Map<Integer, Float> DISCOUNTS = new HashMap<>();

    static {
        DISCOUNTS.put(5, 0.25f);
        DISCOUNTS.put(4, 0.2f);
        DISCOUNTS.put(3, 0.15f);
        DISCOUNTS.put(2, 0.05f);
        DISCOUNTS.put(1, 0f);
        DISCOUNTS.put(0, 0f);
    }

    public static float price(List<Integer> books) {
        List<Integer> bookList = books;
        List<Set<Integer>> setsOfDifferentBooks = extractAllSetsOfDifferentBooks(bookList);

        float totalPrice = 0f;
        for (Set<Integer> aSetOfDifferentBooks : setsOfDifferentBooks) {
            totalPrice += getPriceForASetOfDifferentBook(aSetOfDifferentBooks.size());
        }
        return totalPrice;
    }

    private static double getPriceForASetOfDifferentBook(final Integer differentBookCount) {
        double discount = DISCOUNTS.get(differentBookCount);
        double totalPriceWithoutDiscount = differentBookCount * BOOK_PRICE;
        return totalPriceWithoutDiscount - (totalPriceWithoutDiscount * discount);
    }

    private static List<Set<Integer>> extractAllSetsOfDifferentBooks(List<Integer> allBooks) {
        List<Integer> remainingBooks = new ArrayList<>(allBooks);
        List<Set<Integer>> setsOfDifferentBooks = new ArrayList<>(10);

        while (remainingBooks.size() > 0) {
            final Set<Integer> oneSetOfDifferentBooks = extractNextSetOfDifferentBook(remainingBooks);
            setsOfDifferentBooks.add(oneSetOfDifferentBooks);
            removeCountedBooks(oneSetOfDifferentBooks, remainingBooks);
        }

        return setsOfDifferentBooks;
    }

    private static Set<Integer> extractNextSetOfDifferentBook(List<Integer> books) {
        Set<Integer> differentBooks = new HashSet<>(5);
        differentBooks.addAll(books);
        return differentBooks;
    }

    private static void removeCountedBooks(final Set<Integer> countedBooks, final List<Integer> remainingBooks) {
        for (Integer countedBook : countedBooks) {
            remainingBooks.remove(countedBook);
        }
    }
}