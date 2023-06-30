package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("author already exist!");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.remove(authorName)) {
            System.out.println("Remove author successfully!");
        }
    }

    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() +
                ": " + this.getCost() + "$";
    }
}
