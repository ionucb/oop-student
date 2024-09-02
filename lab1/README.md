
# Simple Library Management System

<b>Objective:</b> To create a simple Library Management System using Object-Oriented Programming concepts.

## Table of Contents
- [Overview](#overview)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Example of usage](#example-of-usage)

## Overview
This Java program is a simple library management system. The program aims to implement the simplest functionality: adding, deleting and viewing books.

## Getting Started
To run the Library Management System, follow these steps:

1. Clone the repository to your local machine.
   ```sh
   git clone https://github.com/ionucb/oop-student.git
   ```

2. Open the project in your favorite Java development environment (e.g., IntelliJ IDEA, Eclipse).

3. Compile and run the `Main.java` file.

4. Follow the on-screen instructions to interact with the program.

## Usage
- Upon running the program, you will be presented with a menu to choose from adding book, deleting book, view books and exit from program.

- For each operation, follow the input prompts and provide the required information.

## Example of usage
After compiling and running the `Main.java` file we will choose an option from this menu

```md
Library Management System
1. Add Book
2. Delete Book
3. List All Books
0. Exit
Enter your choice:
```

Now choosing option number 1 (Add Book), and enter the book information (id, title, author and isbn):

```md
Enter your choice: 1
Enter Book ID: 1
Enter Book Title: Structure and Interpretation of Computer Programs
Enter Book Author: Harold Abelson
Enter Book ISBN: 9780262543231          
Book added successfully!
```
Now we will check if our book has been added by choosing option 3 (List All Books):

```md
Enter your choice: 3
Book{id=1, title='Structure and Interpretation of Computer Programs', author='Harold Abelson', isbn=9780262543231}
```
I've added a few more books to make the list bigger and now we're going to test the deletion. The list of books now looks like this:

```md
Enter your choice: 3
Book{id=1, title='Structure and Interpretation of Computer Programs', author='Harold Abelson', isbn=9780262543231}
Book{id=2, title='Computer Systems: A Programmer's Perspective', author='Randal Bryant', isbn=9780134092669}
Book{id=3, title='Readings in Database Systems', author='Joseph M. Hellerstein', isbn=9780262693141}
```
Let's try to delete the book with id 2.

```md
Enter your choice: 2
Enter Book ID to delete: 2
Book deleted successfully!
```
Magic, the book with id 2 is gone.

```md
Enter your choice: 3
Book{id=1, title='Structure and Interpretation of Computer Programs', author='Harold Abelson', isbn=9780262543231}
Book{id=3, title='Readings in Database Systems', author='Joseph M. Hellerstein', isbn=9780262693141}
```