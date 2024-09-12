#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Book {
private:
    int id;
    string title;
    string author;
    long isbn;

public:
    Book(int id, const string& title, const string& author, long isbn) 
        : id(id), title(title), author(author), isbn(isbn) {}

    int getId() const {
        return id;
    }

    string getTitle() const {
        return title;
    }

    string getAuthor() const {
        return author;
    }

    long getIsbn() const {
        return isbn;
    }

    void print() const {
        cout << "Book{" 
             << "id=" << id 
             << ", title='" << title << '\''
             << ", author='" << author << '\''
             << ", isbn=" << isbn 
             << '}' << endl;
    }
};

class Library {
private:
    vector<Book> books;

public:
    void addBook(const Book& book) {
        books.push_back(book);
        cout << "Book added successfully!" << endl;
    }

    void deleteBook(int id) {
        auto it = remove_if(books.begin(), books.end(), [id](const Book& book) {
            return book.getId() == id;
        });
        if (it != books.end()) {
            books.erase(it, books.end());
            cout << "Book deleted successfully!" << endl;
        } else {
            cout << "Book not found!" << endl;
        }
    }

    void listBooks() const {
        for (const auto& book : books) {
            book.print();
        }
    }

    Book inputBookDetails() {
        int id;
        string title;
        string author;
        long isbn;

        cout << "Enter Book ID: ";
        cin >> id;
        cin.ignore(); // consume newline

        cout << "Enter Book Title: ";
        getline(cin, title);

        cout << "Enter Book Author: ";
        getline(cin, author);

        cout << "Enter Book ISBN: ";
        cin >> isbn;

        return Book(id, title, author, isbn);
    }

    void start() {
        while (true) {
            cout << "\nLibrary Management System" << endl;
            cout << "1. Add Book" << endl;
            cout << "2. Delete Book" << endl;
            cout << "3. List All Books" << endl;
            cout << "0. Exit" << endl;
            cout << "Enter your choice: ";

            int choice;
            cin >> choice;
            cin.ignore(); // Fix for input buffer

            switch (choice) {
                case 1:
                    addBook(inputBookDetails());
                    break;
                case 2:
                    {
                        int id;
                        cout << "Enter Book ID to delete: ";
                        cin >> id;
                        deleteBook(id);
                    }
                    break;
                case 3:
                    listBooks();
                    break;
                case 0:
                    cout << "Exiting..." << endl;
                    return;
                default:
                    cout << "Invalid choice, please enter a number between 0 and 3." << endl;
                    break;
            }
        }
    }
};

int main() {
    Library library;
    library.start();
    return 0;
}
