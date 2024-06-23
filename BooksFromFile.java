
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        
        
    }
    
    public static List<Book> readBooks(String file){
        List<Book> books = new ArrayList<>();
        try {
            books = Files.lines(Paths.get(file))
                    .map(line -> {
                        String[] parts = line.split(",");
                        String name = parts[0];
                        int publishingYear = Integer.parseInt(parts[1]);
                        int pageCount = Integer.parseInt(parts[2]);
                        String author = parts[3];
                        return new Book(name, publishingYear, pageCount, author);
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return books;
    }


}
