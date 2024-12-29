import java.util.Arrays;

public class BookManager {
    private Book[] books;

    public BookManager(Book[] books) {
        this.books = books;
    }

    public void printBooksByAuthor(String author) {
        System.out.println("Books by " + author + ": [");
        for (Book book : books) {
            if (Arrays.asList(book.getAuthors()).contains(author)) {
                System.out.println(book);
            }
        }
        System.out.println("]\n");
    }

    public void printBooksByPublisher(String publisher) {
        System.out.println("Books published by " + publisher + ": [" + //
                "");
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                System.out.println(book);
            }
        }
        System.out.println("]\n");
    }

    public void printBooksAfterYear(int year) {
        System.out.println("Books published after " + year + ": [" + //
                "");
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println(book);
            }
        }
        System.out.println("]\n");
    }
}