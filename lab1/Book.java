public class Book{

    String title;
    String author;
    long isbn;
    
    public String getTitle() {
    return title;
    }

  
    public void setTitle(String newTitle) {
    this.title = newTitle;
    }


    public String getAuthor() {
    return author;
    }

  
    public void setAuthor(String newAuthor) {
    this.author = newAuthor;
    }


    public long getIsbn() {
    return isbn;
    }

  
    public void setTitle(long newIsbn) {
    this.isbn = newIsbn;
    }

    public String ToString(){
        return "Title:"+title + " Author:"+author+"ISBN:"+isbn;
    }

}