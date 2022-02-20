package potter;

public final class Book {
    public int tome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return tome == book.tome;
    }
}
