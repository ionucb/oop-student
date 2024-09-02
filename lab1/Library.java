import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library{

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void deleteBook(int id) {
        if (books.removeIf(book -> book.getId() == id)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void listBooks() {
        books.forEach(System.out::println);
    }    

}