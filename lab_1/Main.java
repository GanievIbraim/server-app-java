public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[] {
                new Book(1, "Java Basics", new String[] { "John Doe" }, "Tech Books", 2020, 300, 29.99, "Paperback"),
                new Book(2, "Advanced Java", new String[] { "Jane Roe" }, "Tech Books", 2022, 450, 39.99, "Hardcover"),
                new Book(3, "Python Programming", new String[] { "John Doe", "Jane Roe" }, "Code Books", 2021, 500,
                        49.99, "Paperback"),
                new Book(4, "Web Development", new String[] { "Alice Smith" }, "Web Books", 2019, 320, 24.99,
                        "Paperback"),
        };

        BookManager store = new BookManager(books);

        store.printBooksByAuthor("John Doe");
        store.printBooksByPublisher("Tech Books");
        store.printBooksAfterYear(2020);

        System.out.println("Output information using toString():");
        System.out.println(books[1]);
    }
}