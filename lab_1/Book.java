import java.util.Arrays;

public class Book {
    private int id;
    private String title;
    private String[] authors;
    private String publisher;
    private int year;
    private int pages;
    private double price;
    private String bindingType;

    public Book(int id, String title, String[] authors, String publisher, int year, int pages, double price,
            String bindingType) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.bindingType = bindingType;
    }

    public Book(int id, String title, String author, String publisher, int year, int pages, double price,
            String bindingType) {
        this(id, title, new String[] { author }, publisher, year, pages, price, bindingType);
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    // Переопределение методов toString и hashCode
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Authors: " + Arrays.toString(authors) + "\n" +
                "Publisher: " + publisher + "\n" +
                "Year: " + year + "\n" +
                "Pages: " + pages + "\n" +
                "Price: " + price + "$\n" +
                "Binding Type: " + bindingType + "\n";
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { id, title, authors, publisher, year, pages, price, bindingType });
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book book = (Book) obj;
        return id == book.id &&
                year == book.year &&
                pages == book.pages &&
                Double.compare(book.price, price) == 0 &&
                title.equals(book.title) &&
                Arrays.equals(authors, book.authors) &&
                publisher.equals(book.publisher) &&
                bindingType.equals(book.bindingType);
    }
}
